package com.quiromasaje2.spring.app.models.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.quiromasaje2.spring.app.models.dao.IEmpleadoDao;
import com.quiromasaje2.spring.app.models.entity.Empleado;
import com.quiromasaje2.spring.app.models.entity.Role;
import com.quiromasaje2.spring.app.models.entity.Usuario;
import com.quiromasaje2.spring.app.security.repository.IUsuarioDao;

@Service
public class EmpleadoServiceImple implements IEmpleadoService{

	@Autowired
	private IEmpleadoDao empleadoDao;
	
	@Autowired
	private IUsuarioDao usuarioDao;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Override
	@Transactional(readOnly = true)
	public List<Empleado> findAll() {
		
		return (List<Empleado>) empleadoDao.findAll() ;
	}

	@Override
	@Transactional
	public Empleado save(Empleado usuario) {
		Usuario user = new Usuario();
		Empleado Usuario = new Empleado();
		Usuario.setApellido(usuario.getApellido());
		Usuario.setCreateAt(new Date());
		Usuario.setEmail(usuario.getEmail());
		Usuario.setNombre(usuario.getNombre());
		Usuario = empleadoDao.save(Usuario);
		user.setEnabled(true);
		user.setId(Usuario.getId());
		user.setPassword(passwordEncoder.encode(Usuario.getPassword()));
		List<Role> roles= new ArrayList<>();
		roles.add(new Role(user.getId(),"ROLE_USER"));
		user.setRoles(roles);
		user.setUsername(Usuario.getNombre());
		usuarioDao.save(user);
		return Usuario;
	}

	@Override
	@Transactional(readOnly = true)
	public Empleado findById(Long id) {

		return empleadoDao.findById(id).orElse(null);
	}

	@Override
	public void delete(Empleado Usuario) {
		empleadoDao.delete(Usuario);
		
	}



//	@Override
//	public Usuario save(UserForm form) {
//		return UsuarioDao.save(form);
//	}

	

}
