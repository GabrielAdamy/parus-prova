package com.parus.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.parus.entities.Cliente;
import com.parus.repository.ClienteRepository;


@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repository;
	
	@Transactional(readOnly = true)
	public List<Cliente> findAll() {
		List<Cliente> list = repository.findAll();		
		return list.stream().map(x -> new Cliente(x)).collect(Collectors.toList());
		

	}
}
