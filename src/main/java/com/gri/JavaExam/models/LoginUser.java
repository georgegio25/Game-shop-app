// r
// This file is needed to validate User (this procedure is different in JAVA)

package com.gri.JavaExam.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class LoginUser {
	@NotEmpty(message="Email is required")
	@Email(message="Invalid email format")
	private String email;
	
	@NotEmpty(message="Password is required")
	private String password;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
