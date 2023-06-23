package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Doctor;
import com.example.demo.service.DoctorService;

import org.springframework.ui.Model;


import java.util.List;

@Controller
@RequestMapping("/doctors")
public class DoctorController {
    private final DoctorService doctorService;

    @Autowired
    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping
   	public String getAllStudents(Model model){
       	List<Doctor> doctors=doctorService.getAllDoctors();
   		model.addAttribute("doctors", doctors);
   		return "doctor-home";
   	}

    @GetMapping("/{id}")
    public Doctor getDoctorById(@PathVariable Long id) {
        return doctorService.getDoctorById(id);
    }

    @PostMapping
    public Doctor createDoctor(Doctor doctor) {
        return doctorService.saveDoctor(doctor);
    }

    @PutMapping("/{id}")
    public Doctor updateDoctor(@PathVariable Long id, @RequestBody Doctor doctorDetails) {
        Doctor doctor = doctorService.getDoctorById(id);
        if (doctor != null) {
            doctor.setName(doctorDetails.getName());
            doctor.setEmail(doctorDetails.getEmail());
            doctor.setPhone(doctorDetails.getPhone());
            doctor.setSpecialization(doctorDetails.getSpecialization());
            doctor.setExperience(doctorDetails.getExperience());
            doctor.setBio(doctorDetails.getBio());

            return doctorService.saveDoctor(doctor);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteDoctor(@PathVariable Long id) {
        doctorService.deleteDoctor(id);
    }
    
    
    //update-doctor

 // Get request to display the update form
     @GetMapping("/{id}/update")
     public String showUpdateForm(@PathVariable("id") Long id, Model model) {
         // Retrieve the doctor from the database
         Doctor doctor = doctorService.getDoctorById(id);

         // Add the doctor object to the model
         model.addAttribute("doctor", doctor);

         // Return the name of the update form view
         return "update-doctor";
     }

     // Post request to handle the form submission and update the doctor
     @PostMapping("/update")
     public String updateDoctorr(@ModelAttribute("doctor") Doctor doctor) {
         // Update the doctor in the database
         this.updateDoctor(doctor.getId(),doctor);

         // Redirect to the doctor details page or any other desired page
         return "redirect:/doctors";
     }

     //register-doctor

 	@PostMapping("/register")
     public String processLogin(@RequestParam("name") String name, @RequestParam String email, @RequestParam String phone,@RequestParam String specialization,@RequestParam int experience, @RequestParam String bio ) {
 		Doctor doctor=new Doctor();
 		 doctor.setId(0L);
         doctor.setName(name);
         doctor.setEmail(email);
         doctor.setPhone(phone);
         doctor.setSpecialization(specialization);
         doctor.setExperience(experience);
         doctor.setBio(bio);
         //System.out.println(email);
         
         doctorService.saveDoctor(doctor);
         return "redirect:/doctors/home";
     }


}