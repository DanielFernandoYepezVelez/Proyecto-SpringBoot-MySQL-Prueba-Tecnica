package com.nextappoficial.springboot.app.policy.sistem.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nextappoficial.springboot.app.policy.sistem.models.entity.InsurancePolicy;
import com.nextappoficial.springboot.app.policy.sistem.models.repository.IInsurancePolicyRepository;

@Service
public class InsurancePolicyServiceImpl implements IInsurancePolicyService {
	
	@Autowired
	private IInsurancePolicyRepository insurancePolicyRepository;

	@Override
	public List<InsurancePolicy> findAll() {
		return insurancePolicyRepository.findAll() ;
	}

	@Override
	public InsurancePolicy findById(String numberPolicy) {
		return insurancePolicyRepository.findById(numberPolicy).orElse(null);
	}

	@Override
	public InsurancePolicy save(InsurancePolicy insurancePolicy) {
		return insurancePolicyRepository.save(insurancePolicy);
	}

	@Override
	public void delete(String numberPolicy) {
		insurancePolicyRepository.deleteById(numberPolicy);
	}

}