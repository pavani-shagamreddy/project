package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Receptionist;
import com.example.demo.repository.ReceptionistRepo;

@Service
public class ReceptionistService {
	@Autowired
	private ReceptionistRepo repository;
	
	public String saveUser(Receptionist r) {
		repository.save(r);
		return "user created";
	}

	public List<Receptionist> getAllUsers() {
		return repository.findAll();
	}

	public Optional<Receptionist> getUser(int id) throws UserNotFoundException {
		Optional<Receptionist> user = repository.findById(id);
		if (user.isPresent()) {
			return repository.findById(id);
		} 
		else {

			throw new UserNotFoundException("user not found with id: " + id);
		}
	}

	public void deleteUser(int id) throws UserNotFoundException {
		Optional<Receptionist> user = repository.findById(id);
		if (user.isPresent()) {
			repository.deleteById(id);
		} else {
			throw new UserNotFoundException("user not found with id: " + id);
		}
	}

 	public boolean authenticate(String email, String password) {
        	Receptionist r = repository.findByEmail(email);
        if (r != null) {
            // Compare the entered password with the stored password
            return password.equals(r.getPassword());
        }
        return false;
    }




}
