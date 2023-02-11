package com.nextappoficial.springboot.app.policy.sistem.models.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nextappoficial.springboot.app.policy.sistem.models.entity.InsurancePolicy;

public interface IInsurancePolicyRepository extends JpaRepository<InsurancePolicy, String> {

}