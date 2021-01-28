package com.parus.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.parus.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{
	
	Cliente findById(long id);
}
