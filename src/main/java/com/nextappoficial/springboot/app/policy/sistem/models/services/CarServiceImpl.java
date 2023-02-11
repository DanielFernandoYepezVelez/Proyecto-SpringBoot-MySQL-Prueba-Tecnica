package com.nextappoficial.springboot.app.policy.sistem.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nextappoficial.springboot.app.policy.sistem.models.entity.Car;
import com.nextappoficial.springboot.app.policy.sistem.models.repository.ICarRepository;

@Service
public class CarServiceImpl implements ICarService {
	
	@Autowired
	private ICarRepository carRepository;

	@Override
	public List<Car> findAll() {
		return (List<Car>) carRepository.findAll();
	}

	@Override
	public Car findById(String registrationNumber) {
		return carRepository.findById(registrationNumber).orElse(null);
	}

	@Override
	public Car save(Car car) {
		return carRepository.save(car);
	}

	@Override
	public void delete(String registrationNumber) {
		carRepository.deleteById(registrationNumber);
	}

}