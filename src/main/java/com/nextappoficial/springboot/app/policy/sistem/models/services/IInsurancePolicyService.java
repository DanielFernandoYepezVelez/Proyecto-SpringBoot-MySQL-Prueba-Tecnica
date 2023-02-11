package com.nextappoficial.springboot.app.policy.sistem.models.services;

import java.util.List;

import com.nextappoficial.springboot.app.policy.sistem.models.entity.InsurancePolicy;

public interface IInsurancePolicyService {
	
	public List<InsurancePolicy> findAll();
	
	public InsurancePolicy findById(String numberPolicy);
	
	public InsurancePolicy save(InsurancePolicy insurancePolicy);
	
	public void delete(String numberPolicy);

}