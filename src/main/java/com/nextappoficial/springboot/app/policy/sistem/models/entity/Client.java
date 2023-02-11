package com.nextappoficial.springboot.app.policy.sistem.models.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name = "clients")
public class Client implements Serializable {

	@Id
	@NotEmpty(message = "No Puede Ser Vacío")
	private String dni;

	@NotEmpty(message = "No Puede Ser Vacío")
	private String name;
	
	@NotEmpty(message = "No Puede Ser Vacío")
	@Column(name = "birth_date")
	private String birthDate;
	
	@NotEmpty(message = "No Puede Ser Vacío")
	private String address;
	
	@NotEmpty(message = "No Puede Ser Vacío")
	private String city;
	
	@JsonIgnoreProperties({"client", "hibernateLazyInitializer", "handler"})
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "client", cascade = CascadeType.ALL)
	private List<InsurancePolicy> policies;
	
	public Client() {
		this.policies = new ArrayList<>();
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	public List<InsurancePolicy> getPolicies() {
		return policies;
	}

	public void setPolicies(List<InsurancePolicy> policies) {
		this.policies = policies;
	}

	private static final long serialVersionUID = 1L;
}