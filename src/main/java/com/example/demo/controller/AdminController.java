package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Admin;
import com.example.demo.repository.AdminRepo;
import com.example.demo.service.AdminService;

@Controller
public class AdminController {
	@Autowired 
	private AdminService service;
	
	@PostMapping("/admin/post")
    public String processLogin(@RequestParam String name, @RequestParam String email, @RequestParam String password) {
        Admin admin = new Admin();
        admin.setId(0);
        admin.setName(name);
        admin.setEmail(email);
        admin.setPassword(password);
        //System.out.println(email);
        //System.out.println(password);
        service.saveUser(admin);
        return "admin-login";
    }

	
	@GetMapping("/register/receptionist")
	public String register() {
		return "register-receptionist";
	}
	
	@GetMapping("/admin-register")
	public String registerAdmin() {
		return "register-admin";
	}
	
	 @GetMapping("/a/login")
	    public String login(@RequestParam String email, @RequestParam String password) {
	    	if(service.authenticate(email, password)) {
	    		return "dashboard-home";
	    	}
	    	else {
	    		return "error";
	    	}
	    }
	 
	 @GetMapping("/admin/home")
	 public String adminHome() {
		 return "admin-home";
	 }
}
