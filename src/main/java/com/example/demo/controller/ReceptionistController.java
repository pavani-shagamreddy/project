package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.example.demo.entity.Receptionist;
import com.example.demo.service.ReceptionistService;


@Controller
public class ReceptionistController {
	
	@Autowired
	private ReceptionistService service;
	
	@GetMapping("/home")
	public String home() {
		return "home";
	}
	
	@GetMapping("/admin/login")
	public String admin() {
		return "admin-login";
	}
	
	@GetMapping("/receptionist/login")
	public String user() {
		return "receptionist-login";
	}
	
//	@PostMapping("post")
//	public ResponseEntity<User> saveUser(@RequestBody @Valid User user) {
//		return new ResponseEntity<>(service.saveUser(user), HttpStatus.CREATED);
//	}

	@PostMapping("/register")
    public String processLogin(@RequestParam String name, @RequestParam String email, @RequestParam String password) {
        Receptionist r = new Receptionist();
        r.setName(name);
        r.setId(0);
        r.setEmail(email);
        r.setPassword(password);
        //System.out.println(email);
        //System.out.println(password);
        service.saveUser(r);
        return "redirect:/receptionist/login";
    }

    @GetMapping("/login/success")
    public String showSuccessPage() {
        return "receptionist-dashboard";
    }
    
    @GetMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password) {
    	if(service.authenticate(email, password)) {
    		return "redirect:/login/success";
    	}
    	else {
    		return "error";
    	}
    }
	
}
