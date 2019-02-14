package com.quiromasaje2.spring.app.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.quiromasaje2.spring.app.models.entity.Empleado;
import com.quiromasaje2.spring.app.models.entity.Usuario;
import com.quiromasaje2.spring.app.models.service.IEmpleadoService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class EmpleadoController {

	@Autowired
	private IEmpleadoService UsuarioService;
	
	@GetMapping("/usuarios")
	public List<Empleado> index() {
		return UsuarioService.findAll();
	}
	@GetMapping("/usuarios/{id}")
	public Empleado show(@PathVariable Long id) {
		return this.UsuarioService.findById(id);
	}
	
	@PostMapping("/usuarios")
	@ResponseStatus(HttpStatus.CREATED)
	public Empleado create(@RequestBody Empleado Usuario) {
		Usuario.setCreateAt(new Date());
		return UsuarioService.save(Usuario);
	}
	
	@PutMapping("/usuarios/update/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Empleado update(@RequestBody Empleado cliente, @PathVariable Long id) {
		Empleado currentUsuario = this.UsuarioService.findById(id);
		currentUsuario.setNombre(cliente.getNombre());
		currentUsuario.setApellido(cliente.getApellido());
		currentUsuario.setEmail(cliente.getEmail());
		this.UsuarioService.save(currentUsuario);
		return currentUsuario;
	}
	@DeleteMapping("/clientes/delete/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		Empleado currentUsuario = this.UsuarioService.findById(id);
		this.UsuarioService.delete(currentUsuario);
	}
}
