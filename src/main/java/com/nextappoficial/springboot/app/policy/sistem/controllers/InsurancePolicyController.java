package com.nextappoficial.springboot.app.policy.sistem.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nextappoficial.springboot.app.policy.sistem.models.entity.InsurancePolicy;
import com.nextappoficial.springboot.app.policy.sistem.models.services.IInsurancePolicyService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class InsurancePolicyController {
	
	@Autowired
	private IInsurancePolicyService insurancePolicyService;
	
	@GetMapping("/policies")
	public List<InsurancePolicy> getPolicies() {
		return insurancePolicyService.findAll();
	}
	
	@GetMapping("/policy/{numberPolicy}")
	public ResponseEntity<?> showPolicy(@PathVariable String numberPolicy) {
		InsurancePolicy insurancePolicy  = null;
		Map<String, Object> response = new HashMap<String, Object>();
		
		// En Caso Tal De Que Tengamos Un Error En La Base De Datos, Lo Manejamos Con El Try - Catch
		try {
			insurancePolicy = insurancePolicyService.findById(numberPolicy);
		} catch(DataAccessException e) {
			response.put("message", "Error Al Realizar La Consulta En La Base De Datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if(insurancePolicy == null) {
			response.put("message", "Error: La Poliza Con El ID: ".concat(numberPolicy.toString().concat(" No Existe En El Sistema")));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<InsurancePolicy>(insurancePolicy, HttpStatus.OK);
	}
	
	@PostMapping("/policy")
	public ResponseEntity<?> create(@Valid @RequestBody InsurancePolicy policy, BindingResult result) {
		InsurancePolicy policyDB = null;
		Map<String, Object> response = new HashMap<String, Object>();
		
		if(result.hasErrors()) {
			/* ============ PROGRAMACIÓN FUNCIONAL (STREAMS) ============== */
			List<String> errors = result.getFieldErrors()
					.stream()
					.map(error -> "El Campo '" + error.getField() + "' " + error.getDefaultMessage())
					.collect(Collectors.toList());
			
			response.put("errors", errors);		
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		
		// En Caso Tal De Que Tengamos Un Error En La Base De Datos, Lo Manejamos Con El Try - Catch
		try {
			policyDB = insurancePolicyService.save(policy);
		} catch(DataAccessException e) {
			response.put("message", "Error Al Realizar El Insert En La Base De Datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("message", "La Poliza Del Automovil Se Creo Exitosamente");
		response.put("policy", policyDB);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}

}