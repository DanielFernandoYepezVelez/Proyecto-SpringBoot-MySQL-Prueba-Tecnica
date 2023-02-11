package com.nextappoficial.springboot.app.policy.sistem.models.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "cars")
public class Car implements Serializable {

	@Id
	@NotEmpty(message = "No Puede Ser Vacío")
	@Column(name = "registration_number")
	private String registrationNumber;
	
	@NotEmpty(message = "No Puede Ser Vacío")
	private String model;
	
	@NotNull(message = "No Puede Ser Vacío")
	private Integer inspection;

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Integer getInspection() {
		return inspection;
	}

	public void setInspection(Integer inspection) {
		this.inspection = inspection;
	}

	private static final long serialVersionUID = 1L;
}
