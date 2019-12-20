package com.green.myspringboot21.ctrl;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.green.myspringboot21.entity.User;
import com.green.myspringboot21.entity.Users;
import com.green.myspringboot21.exception.ResourceNotFoundException;
import com.green.myspringboot21.repository.UserRepository;

@RestController
public class UserRestController {
	@Autowired
	UserRepository u;

	// 요청을 XML로 응답함.
	// @GetMapping(value="/user/list", produces = {"application/xml"} )
	@GetMapping("/user/list")
	public List<User> users() {
		return u.findAll();
	}

	@PostMapping("/user/save")
	public User saveUser(@RequestBody User user) {
		return u.save(user);
	}

	@GetMapping("/user/{id}")
	public User getUser(@PathVariable Long id) {
		// user정보를 조회하고 정보가 없으면 404에러를 던진다.
		return u.findById(id).orElseThrow(() -> new ResourceNotFoundException("user", "id", id));
	}

	@GetMapping("/usersxml")
	public Users usersXml() {
		Users users = new Users();
		users.setUsers(u.findAll());
		return users;
	}

	@PutMapping("/user/{id}")
	public User updateUser(@PathVariable Long id, @RequestBody User userDetail) {
		User user = u.findById(id).orElseThrow(() -> new ResourceNotFoundException("user", "id", id));

		user.setName(userDetail.getName());
		user.setEmail(userDetail.getEmail());
		return u.save(user);
	}

	// ResponseEntity : HTTP 응답을 제어하는 클래스
	@DeleteMapping("/user/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable Long id) {
		u.deleteById(id);

		return new ResponseEntity<>("HTTP바디에 들어가는 문자열", HttpStatus.OK);
	}
}
