package com.mikseros.inventory.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private RoleRepository roleRepo;
	
	@GetMapping("/users")
	public String showUsersList(Model model) {
		List<User> listUsers = userRepo.findAll();
		model.addAttribute("listUsers", listUsers);
		return "users";
	}
	
	@GetMapping("/users/new")
	public String showCreateNewUserForm(Model model) {
		List<Role> listRoles = roleRepo.findAll();
		model.addAttribute("listRoles", listRoles);
		model.addAttribute("user", new User());
		return "user_form";
	}
}
