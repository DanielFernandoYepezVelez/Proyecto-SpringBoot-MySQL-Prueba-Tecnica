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

import com.nextappoficial.springboot.app.policy.sistem.models.entity.Client;
import com.nextappoficial.springboot.app.policy.sistem.models.services.IClientService;

import jakarta.validation.Valid;

@RequestMapping("/api")
@RestController
public class ClientController {
	
	@Autowired
	private IClientService clientService;
	
	@GetMapping("/clients")
	public List<Client> getClients() {
		return clientService.findAll();
	}
		
	@GetMapping("/client/{dni}")
	public ResponseEntity<?> showClient(@PathVariable String dni) {
		Client client = null;
		Map<String, Object> response = new HashMap<String, Object>();
		
		// En Caso Tal De Que Tengamos Un Error En La Base De Datos, Lo Manejamos Con El Try - Catch
		try {
			client = clientService.findById(dni);
		} catch(DataAccessException e) {
			response.put("message", "Error Al Realizar La Consulta En La Base De Datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if(client == null) {
			response.put("message", "Error: El Cliente Con El ID: ".concat(dni.toString().concat(" No Existe En El Sistema")));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Client>(client, HttpStatus.OK);
	}
	
	@PostMapping("/client")
	public ResponseEntity<?> create(@Valid @RequestBody Client client, BindingResult result) {
		Client clientDB = null;
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
			clientDB = clientService.save(client);
			
		} catch(DataAccessException e) {
			response.put("message", "Error Al Realizar El Insert En La Base De Datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("message", "El Cliente Se Creo Exitosamente");
		response.put("client", clientDB);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
}