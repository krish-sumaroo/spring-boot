package com.example.springboot.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserResource {
	
	@Autowired
	private UserDaoService userService;
	
	@GetMapping("/users")
	public List<User> getAllUsers(){
		return userService.findAll();		
	}


}
