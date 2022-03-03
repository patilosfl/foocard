package com.DS.model;

import java.io.Serializable;

public class JwtResponse implements Serializable {

	private static final long serialVersionUID = -8091879091924046844L;
	private final String jwttoken;

	public JwtResponse(String jwttoken) {
		
		System.out.println("in resposne class");
		System.out.println(jwttoken);
		this.jwttoken = jwttoken;
	}

	public String getToken() {
		return this.jwttoken;
	}
}