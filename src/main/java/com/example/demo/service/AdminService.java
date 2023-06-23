package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Admin;
import com.example.demo.repository.AdminRepo;

@Service
public class AdminService {

	@Autowired
	private AdminRepo repo;
	
	public String saveUser(Admin a) {
		repo.save(a);
		return "Admin created";
	}
	
	public boolean authenticate(String email, String password) {
    	Admin a =repo.findByEmail(email);
    if (a!= null) {
        // Compare the entered password with the stored password
        return password.equals(a.getPassword());
    }
    return false;
}
}
