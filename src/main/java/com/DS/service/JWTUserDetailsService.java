package com.DS.service;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;

import com.DS.model.Patient;
import com.DS.repository.UserRepository;

@Service
public class JWTUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userDao;

	@Override
	public UserDetails loadUserByUsername(String useranme) throws UsernameNotFoundException {

		//Patient user = userDao.findByEmail(useranme);
		
		Patient user = getUserdetails(useranme);
		if (user == null) {
			throw new UsernameNotFoundException("User not found with username: " + useranme);
		}
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),new ArrayList<>());
	}

	public Patient getUserdetails(String useranme) {
		if (useranme.contains("@")) {
			return userDao.findByEmail(useranme);
		} else {
			return userDao.findByMobile(useranme);
		}
	}

}
