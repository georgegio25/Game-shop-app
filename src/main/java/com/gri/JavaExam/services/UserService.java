//This file holds sets of methods that we will use for this class in different files
// checking password and email existence in order to allow use it. 

package com.gri.JavaExam.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.gri.JavaExam.models.LoginUser;
import com.gri.JavaExam.models.User;
import com.gri.JavaExam.repos.UserRepo;

@Service
public class UserService {
	@Autowired
	private UserRepo repo;

	public User register(User newUser, BindingResult result) {
		if (repo.findByEmail(newUser.getEmail()).isPresent()) { // findByEmail - camel case!!! 
			result.rejectValue("email", "Unique", "This email is already in use");
		}
		
		if(!newUser.getPassword().equals(newUser.getConfirmPassword())) {
			result.rejectValue("confirmPassword", "Matches", "Password and Confirm password must match");
		}
		
		if(result.hasErrors()) {
			return null;
		}
		
		
		String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
		newUser.setPassword(hashed);
		return repo.save(newUser);
	}
	
	public User login(LoginUser newLogin, BindingResult result) {
		Optional<User>optUser = repo.findByEmail(newLogin.getEmail()); // findByEmail - camel case!!! 
		if(!optUser.isPresent()) {
			result.rejectValue("email", "Unique", "Invalid Credentials");
			return null;
		}
		
		User user = optUser.get();
		if(!BCrypt.checkpw(newLogin.getPassword(), user.getPassword())) {
			result.rejectValue("email", "Matches", "Invalid Credentials");
			return null;
		}
		
		return user;
	}
	// create / update 
	// read
	public User getOne(Long id) {
		return repo.findById(id).orElse(null);
	}
}
