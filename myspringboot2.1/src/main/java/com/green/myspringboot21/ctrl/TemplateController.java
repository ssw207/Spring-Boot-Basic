package com.green.myspringboot21.ctrl;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.green.myspringboot21.entity.User;
import com.green.myspringboot21.repository.UserRepository;

@Controller
public class TemplateController {

	@Autowired
	UserRepository r;

	@GetMapping("/leaf")
	public String leaf(Model model) {
		model.addAttribute("name", "vega2k");
		return "leaf";
	}

	@GetMapping("/index")
	public String user(Model model) {
		model.addAttribute("users", r.findAll());
		return "index";
	}

//	@GetMapping("/signup")
//	public String showSignUpForm(User user) {
//		return "add-user";
//	}

	// BindResult 에 @Valid 결과가 매핑됨
//	@PostMapping("/adduser")
//	public String addUser(@Valid User user, BindingResult result, Model model) {
//		if (result.hasErrors()) {
//			return "add-user";
//		}
//		r.save(user);
//		model.addAttribute("users", r.findAll());
//		return "index";
//	}
}