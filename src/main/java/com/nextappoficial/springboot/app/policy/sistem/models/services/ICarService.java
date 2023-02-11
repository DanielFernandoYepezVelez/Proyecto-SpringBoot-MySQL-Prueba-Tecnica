package com.nextappoficial.springboot.app.policy.sistem.models.services;

import java.util.List;

import com.nextappoficial.springboot.app.policy.sistem.models.entity.Car;

public interface ICarService {

	public List<Car> findAll();
	
	public Car findById(String registrationNumber);
	
	public Car save(Car car);
	
	public void delete(String registrationNumber);

}
