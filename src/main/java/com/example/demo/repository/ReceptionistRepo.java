package com.example.demo.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Receptionist;

@Repository
public interface ReceptionistRepo extends JpaRepository<Receptionist, Integer> {
		Receptionist findByEmail(String email);
}
