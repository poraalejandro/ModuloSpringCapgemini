package com.alejandro.app.service;

import java.util.List;

import com.alejandro.app.entity.Cliente;

public interface ClienteService {
	
	public List<Cliente> mostrarTodo();
	
	public Cliente buscarPorId(long id);
	
	public Cliente guardar(Cliente cliente);

	public void borrar(long id);
}
