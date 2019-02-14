package com.quiromasaje2.spring.app.security.service;

import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.quiromasaje2.spring.app.models.entity.Usuario;
import com.quiromasaje2.spring.app.security.repository.IUsuarioDao;
import static java.util.Collections.emptyList;

@Service("userDetailsService")
public class UsuarioService implements UserDetailsService {

	private IUsuarioDao accountRepository;
	private final AccountStatusUserDetailsChecker detailsChecker = new AccountStatusUserDetailsChecker();

	public UsuarioService(IUsuarioDao accountRepository) {
		this.accountRepository = accountRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		// Fetch the account corresponding to the given username
		Usuario account = accountRepository.findByUsername(username);

		// If the account doesn't exist
		if (account == null) {
			throw new UsernameNotFoundException("User " + username + " not found");
		}

		// User(username, password, enabled, accountNonExpired, credentialsNotExpired,
		// accountNonLocked, authorities)
	
		
		User user = new User(account.getUsername(), account.getPassword(), account.getEnabled(), true, true, true, emptyList());
		
		detailsChecker.check(user);

		return user;
	}

}