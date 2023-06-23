package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	  @GetMapping("/registerDoctor") 
	  public String registerDoctor() { 
		  return "register-doctor";
		  }
	 
	@GetMapping("/dashboard/home")
	public String dashboardHome() {
		return "dashboard-home";
	}
	@GetMapping("/doctors/home")
	public String doctorsHome() {
		return "doctor-home";
	}
	@GetMapping("/nurses/home")
	public String nursesHome() {
		return "nurse-home";
	}
	@GetMapping("/receptionists/home")
	public String receptionistsHome() {
		return "receptionist-home";
	}
	

	@GetMapping("/medicines/register")
	public String registerMedicine() {
		return "register-medicine";
	}
	
	@GetMapping("/medicines/home")
	public String medicinesHome() {
		return "medicine-home";
	}
	
	
	@GetMapping("/patients/home")
	public String patientsHome() {
		return "patient-home";
	}
	
	@GetMapping("/appointments/home")
	public String appointmentsHome() {
		return "appointment-home";
	}
	
	/*
	 * @GetMapping("/admin/dashboardp") public String adminDashboard() { return
	 * "admindashp"; }
	 * 
	 * @GetMapping("/admin/docp") public String adminDocterdetails() { return
	 * "docp"; }
	 * 
	 * @GetMapping("/admin/appointment-detailsp") public String
	 * adminAppointmentdetails() { return "appointment-detailsp"; }
	 * 
	 * @GetMapping("/admin/nurse-details") public String adminnursedetails() {
	 * return "nurse-details.html"; }
	 * 
	 * @GetMapping("/admin/medicine-details") public String adminmedicinedetails() {
	 * return "medicine-details.html"; }
	 * 
	 * @GetMapping("/admin/patient-details") public String adminpatientdetails() {
	 * return "patient-details.html"; }
	 * 
	 * @GetMapping("/admin/receptionist-details") public String
	 * adminreceptionistdetails() { return "receptionist-details.html"; }
	 */
	
	
	
}
