package com.quiromasaje2.spring.app.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quiromasaje2.spring.app.models.entity.Usuario;
import com.quiromasaje2.spring.app.models.form.UserForm;

public interface IUsuarioDao extends JpaRepository<Usuario, Long>{

	public Usuario findByUsername(String username);

	public Usuario save(UserForm form);
}
