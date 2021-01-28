package com.parus.resource;

import static org.springframework.http.HttpStatus.NO_CONTENT;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.parus.entities.Cliente;
import com.parus.repository.ClienteRepository;
import com.parus.service.ClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteResource {
	private ClienteRepository clienteRepository;

	public ClienteResource(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}

	@Autowired
	private ClienteService service;

	@GetMapping("{id}")
	public Cliente getById(@PathVariable long id) {
		return clienteRepository.findById(id);
	}

	@GetMapping
	public ResponseEntity<List<Cliente>> findAll() {
		List<Cliente> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente save(@RequestBody Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	@DeleteMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		clienteRepository.findById(id).map(cliente -> {
			clienteRepository.delete(cliente);
			return cliente.toString();
		}).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "not found"));
	}

	@PutMapping("{id}")
	@ResponseStatus(NO_CONTENT)
	public void update(@PathVariable Long id, @RequestBody Cliente cliente) {
		clienteRepository.findById(id).map(p -> {
			cliente.setId(p.getId());
			clienteRepository.save(cliente);
			return cliente;
		}).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "cliente não encontrado."));
	}
}
