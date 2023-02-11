package com.nextappoficial.springboot.app.policy.sistem.models.services;

import java.util.List;

import com.nextappoficial.springboot.app.policy.sistem.models.entity.Client;

public interface IClientService {
	
	public List<Client> findAll();
	
	public Client findById(String dni);
	
	public Client save(Client client);
	
	public void delete(String dni);

}