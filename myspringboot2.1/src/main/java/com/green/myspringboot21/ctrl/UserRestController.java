package com.green.myspringboot21.ctrl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.green.myspringboot21.entity.User;
import com.green.myspringboot21.repository.UserRepository;

@RestController
public class UserRestController {
	@Autowired
	UserRepository userRepository;
	
	@GetMapping("/users")
	public List<User> users() {
		return userRepository.findAll();
	}
	
//	@PostMapping("/saveUser")
//	public List<User> saveUser() {
//		new User("id", "mail");
//		return userRepository.save();
//	}
}
