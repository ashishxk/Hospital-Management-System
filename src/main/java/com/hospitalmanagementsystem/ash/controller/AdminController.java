package com.hospitalmanagementsystem.ash.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.hospitalmanagementsystem.ash.model.Appointment;
import com.hospitalmanagementsystem.ash.model.Doctor;
import com.hospitalmanagementsystem.ash.model.Patient;
import com.hospitalmanagementsystem.ash.service.IAppointmentService;
import com.hospitalmanagementsystem.ash.service.IDoctorService;
import com.hospitalmanagementsystem.ash.service.IPatientService;

@Controller
public class AdminController {

	@Autowired
	private IDoctorService doctorService;

	@Autowired
	private IPatientService patientService;

	@Autowired
	private IAppointmentService appointmentService;

	// View All Doctors

	@GetMapping("/doctors")
	public String viewAllDoctors(Model model) {
		List<Doctor> doctors = doctorService.getAllDoctors();
		model.addAttribute("doctorsList", doctors);
		return "doctor";
	}

	@GetMapping("/addNewDoctorForm")
	public String createDoctorForm(Model model) {
		model.addAttribute("doctor", new Doctor());
		return "doctor-form";
	}

	@PostMapping("/saveNewDoctor")
	public String saveDoctor(@ModelAttribute("doctor") Doctor doctor) {
		doctorService.addDoctor(doctor);
		return "redirect:/doctors";
	}

	// Update Doctor

	@GetMapping("/updateDoctorForm/{id}")
	public String showDoctorUpdateForm(@PathVariable(value = "id") Long id, Model model) {
		Doctor doctor = doctorService.getDoctorById(id);
		model.addAttribute("doctor", doctor);
		return "doctor-update";
	}

	@PostMapping("/updateDoctor")
	public String updateDoctor(Doctor doctor) {
		doctorService.updateDoctor(doctor);
		return "redirect:/doctors";
	}

	// Delete Doctor
	@GetMapping("/delete/doctor/{id}")
	public String deleteDoctor(@PathVariable("id") Long id) {
		doctorService.deleteDoctor(id);
		return "redirect:/doctors";
	}

	// View All Patients

	@GetMapping("/patients")
	public String viewAllPatients(Model model) {
		List<Patient> patients = patientService.getAllPatients();
		model.addAttribute("patientsList", patients);
		return "patient";
	}

	@GetMapping("/addNewPatientForm")
	public String createPatientForm(Model model) {
		model.addAttribute("patient", new Patient());
		return "patient-form";
	}

	@PostMapping("/saveNewPatient")
	public String savePatient(@ModelAttribute("patient") Patient patient) {
		patientService.addPatient(patient);
		return "redirect:/patients";
	}

	// Update Patient

	@GetMapping("/updatePatientForm/{id}")
	public String showPatientUpdateForm(@PathVariable(value = "id") Long id, Model model) {
		Patient patient = patientService.getPatientById(id);
		model.addAttribute("patient", patient);
		return "patient-update";
	}

	@PostMapping("/updatePatient")
	public String updatePatient(Patient patient) {
		patientService.updatePatient(patient);
		return "redirect:/patients";
	}

	// Delete Patient
	@GetMapping("/delete/patient/{id}")
	public String deletePatient(@PathVariable("id") Long id) {
		patientService.deletePatient(id);
		return "redirect:/patients";
	}

	// View All Appointments

	@GetMapping("/appointments")
	public String listAllAppointments(Model model) {
		List<Appointment> appointment = appointmentService.getAllAppointments();
		model.addAttribute("appointments", appointment);
		return "appointment";
	}
	
	@GetMapping("/doctor")
	public String listDoctorAppointments(Model model) {
		List<Appointment> appointment = appointmentService.getAllAppointments();
		model.addAttribute("appointmentsList", appointment);
		return "doctor-home";
	}
	
	@GetMapping("/patient")
	public String listPatientAppointments(Model model) {
		List<Appointment> appointment = appointmentService.getAllAppointments();
		model.addAttribute("appointmentsList", appointment);
		return "patient-home";
	}
	
	
	// Add new Appointment

	@GetMapping("/addNewAppointmentForm")
	public String createAppointmentForm(Model model) {
		List<Patient> patients = patientService.getAllPatients();
		List<Doctor> doctors = doctorService.getAllDoctors();
		model.addAttribute("patientsList", patients);
		model.addAttribute("doctorsList", doctors);
		model.addAttribute("appointment", new Appointment());
		return "appointment-form";
	}

	@PostMapping("/saveNewAppointment")
	public String saveAppointment(@ModelAttribute("appointment") Appointment appointment) {
		appointmentService.addAppointment(appointment);
		return "redirect:/appointments";
	}

	// Update Appointment

	@PostMapping("/update/appointment/{id}")
	public String updateAppointment(@PathVariable("id") Long id,
			@ModelAttribute("appointment") Appointment appointment) {
		appointmentService.updateAppointment(id, appointment);
		return "redirect:/appointments";
	}

	// Delete Appointment

	@GetMapping("/delete/appointment/{id}")
	public String deleteAppointment(@PathVariable("id") Long id) {
		appointmentService.deleteAppointmentById(id);
		return "redirect:/appointments";
	}
}
