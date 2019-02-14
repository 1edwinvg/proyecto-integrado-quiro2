package com.quiromasaje2.spring.app.models.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.quiromasaje2.spring.app.models.entity.Empleado;




public interface IEmpleadoService {

public List<Empleado> findAll();
	
	
	public Empleado save(Empleado form);
	
	public Empleado findById(Long id);
	
	public void delete(Empleado cliente);
	
}
