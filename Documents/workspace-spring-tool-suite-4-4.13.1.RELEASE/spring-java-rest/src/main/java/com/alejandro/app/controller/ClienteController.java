package com.alejandro.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alejandro.app.entity.Cliente;
import com.alejandro.app.models.Ejemplo;
import com.alejandro.app.service.ClienteService;

@RestController
@RequestMapping("/api")
public class ClienteController {
	
	@Autowired
	private ClienteService servicio;
	
	@GetMapping({"/clientes"})
	public List<Cliente> mostrarCliente(){
		return servicio.mostrarTodo();
	}
	
	@GetMapping({"/clientes/{id}"})
	public Cliente buscarCliente(@PathVariable long id) {
		return servicio.buscarPorId(id);
	}
	
	@PostMapping("/clientes")
	public Cliente guardarCliente(@RequestBody Cliente cliente) {
		return servicio.guardar(cliente);
	}
	
	@PutMapping("/clientes/{id}")
	public Cliente actualizarCliente(@RequestBody Cliente cliente,@PathVariable long id) {
		
		Cliente clienteUpdate = servicio.buscarPorId(id);
		
		clienteUpdate.setNombre(cliente.getNombre());
		clienteUpdate.setApellido(cliente.getApellido());
		clienteUpdate.setEmail(cliente.getEmail());
		clienteUpdate.setTelefono(cliente.getTelefono());
		clienteUpdate.setCreatedAt(cliente.getCreatedAt());
		
		return servicio.guardar(clienteUpdate);
	}
	
	@DeleteMapping("/clientes/{id}")
	public void borrarCliente(@PathVariable long id) {
		servicio.borrar(id);
	}
}
