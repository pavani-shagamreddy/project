package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.entity.Patient;
import com.example.demo.repository.PatientRepo;

@Service
public class PatientService {

    @Autowired
    private PatientRepo patientRepository;

   
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

   
    public Optional<Patient> getPatientById(@PathVariable Long id) throws UserNotFoundException{
		Optional<Patient> patient = patientRepository.findById(id);
		if (patient.isPresent()) {
			return  patientRepository.findById(id);
		} 
		else {

			throw new UserNotFoundException("Patient not found with id: " + id);
		}
    }
    
    

  
    public Patient addPatient(@RequestBody Patient patient) {
        return patientRepository.save(patient);
    }

 
    public Patient updatePatient(@PathVariable Long id, @RequestBody Patient patientDetails) {
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient not found"));

        patient.setName(patientDetails.getName());
        patient.setEmail(patientDetails.getEmail());
        // Update other fields as needed

        return patientRepository.save(patient);
    }

 
    public void deletePatient(@PathVariable Long id) {
        patientRepository.deleteById(id);
    }
}
