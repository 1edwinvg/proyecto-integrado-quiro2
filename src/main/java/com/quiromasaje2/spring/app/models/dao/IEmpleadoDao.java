package com.quiromasaje2.spring.app.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quiromasaje2.spring.app.models.entity.Empleado;



public interface IEmpleadoDao extends  JpaRepository<Empleado,Long>{ 

}
