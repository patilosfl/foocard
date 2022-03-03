package com.DS.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.DS.service.JWTUserDetailsService;
import com.DS.authentication.JwtTokenUtil;
import com.DS.model.UserDto;
import com.DS.model.JwtResponse;

@RestController
@CrossOrigin("*")
public class JwtAuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private JWTUserDetailsService userDetailsService;

	@RequestMapping(value = "/user/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody UserDto authenticationRequest) throws Exception {

		authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
		final String userName = authenticationRequest.getUsername();
		final UserDetails userDetails = userDetailsService.loadUserByUsername(userName);
		System.out.println("load user details");
		System.out.println(userDetails);
		final String token = jwtTokenUtil.generateToken(userDetails);
		System.out.println("token from authenticate controller");
		System.out.println(token);
		System.out.println(userDetailsService.user);
		System.out.println(userDetailsService.user.getFirstname());

		JwtResponse rest = new JwtResponse(token);
		System.out.println("  ****************" + rest);
		System.out.println("  ******getToken*******" + rest.getToken());
		System.out.println("  *******hashCode*******" + rest.hashCode());

		HashMap<String, String> authResult = new HashMap<>();
		authResult.put("token", rest.getToken());
		authResult.put("name", userDetailsService.user.getFirstname());

		return ResponseEntity.ok(authResult);

		// return ResponseEntity.ok(new JwtResponse(token));
	}

	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}
}
