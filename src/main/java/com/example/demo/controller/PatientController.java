package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Patient;
import com.example.demo.service.PatientService;



import java.util.List;

@Controller
@RequestMapping("/patients")
public class PatientController {

    private final PatientService patientService;
    
    @Autowired
    public PatientController(PatientService patientService) {
    	this.patientService=patientService;
    }
    
  
    @GetMapping("/register")
    public String registerPatient() {
    	return "register-patient";
    }
    
    
    @PostMapping("/save")
    public String savePatient(@RequestParam String name, @RequestParam String email, @RequestParam String phone, @RequestParam String gender, @RequestParam String dob, @RequestParam String address ) {
        Patient patient=new Patient();
        patient.setId(0L);
        patient.setName(name);
        patient.setEmail(email);
        patient.setDob(dob);
        patient.setPhone(phone);
        patient.setGender(gender);
        patient.setAddress(address);
        //System.out.println(email);
        patientService.addPatient(patient);
        return "patient";
    }
    
    @GetMapping
	public String getAllStudents(Model model){
    	List<Patient> patient=patientService.getAllPatients();
		model.addAttribute("patient", patient);
		return "patient-home";
	}
}

