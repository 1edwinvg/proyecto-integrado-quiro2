package com.quiromasaje2.spring.app.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quiromasaje2.spring.app.models.entity.Usuario;


public interface IUsuarioDao extends JpaRepository<Usuario, Long>{

	public Usuario findByUsername(String username);


}
