package com.nextappoficial.springboot.app.policy.sistem.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nextappoficial.springboot.app.policy.sistem.models.entity.Client;
import com.nextappoficial.springboot.app.policy.sistem.models.repository.IClientRepository;

@Service
public class ClientServiceImpl implements IClientService {
	
	@Autowired
	private IClientRepository clientRepository;

	@Override
	public List<Client> findAll() {
		return (List<Client>) clientRepository.findAll();	
	}

	@Override
	public Client findById(String id) {
		return clientRepository.findById(id).orElse(null);
	}

	@Override
	public Client save(Client client) {
		return clientRepository.save(client);
	}

	@Override
	public void delete(String dni) {
		clientRepository.deleteById(dni);
	}

}