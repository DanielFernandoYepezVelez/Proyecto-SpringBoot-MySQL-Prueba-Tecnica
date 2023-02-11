package com.nextappoficial.springboot.app.policy.sistem.models.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name = "insurance_policies")
public class InsurancePolicy implements Serializable {

	@Id
	@NotEmpty(message = "No Puede Ser Vacío")
	@Column(name = "number_policy")
	private String numberPolicy;
	
	@NotEmpty(message = "No Puede Ser Vacío")
	@Column(name = "plane_name")
	private String planeName;
	
	@NotEmpty(message = "No Puede Ser Vacío")
	private String coverage;
	
	@Column(name = "max_value")
	private double maxValue;
	
	@NotEmpty(message = "No Puede Ser Vacío")
	@Column(name = "filing_date")
	private String filingDate;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "client_dni")
	@JsonIgnoreProperties({"insurance_policies", "hibernateLazyInitializer", "handler"})
	private Client client;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "registration_number")
	@JsonIgnoreProperties({"insurance_policies", "hibernateLazyInitializer", "handler"})
	private Car car;

	public String getNumberPolicy() {
		return numberPolicy;
	}

	public void setNumberPolicy(String numberPolicy) {
		this.numberPolicy = numberPolicy;
	}

	public String getPlaneName() {
		return planeName;
	}

	public void setPlaneName(String planeName) {
		this.planeName = planeName;
	}

	public String getCoverage() {
		return coverage;
	}

	public void setCoverage(String coverage) {
		this.coverage = coverage;
	}

	public double getMaxValue() {
		return maxValue;
	}

	public void setMaxValue(double maxValue) {
		this.maxValue = maxValue;
	}

	public String getFilingDate() {
		return filingDate;
	}

	public void setFilingDate(String filingDate) {
		this.filingDate = filingDate;
	}
	
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	private static final long serialVersionUID = 1L;

}