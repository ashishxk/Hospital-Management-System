package com.hospitalmanagementsystem.ash.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hospitalmanagementsystem.ash.model.Admin;
import com.hospitalmanagementsystem.ash.model.Appointment;
import com.hospitalmanagementsystem.ash.model.Doctor;
import com.hospitalmanagementsystem.ash.model.Patient;
import com.hospitalmanagementsystem.ash.repository.AdminRepository;
import com.hospitalmanagementsystem.ash.repository.AppointmentRepository;
import com.hospitalmanagementsystem.ash.repository.DoctorRepository;
import com.hospitalmanagementsystem.ash.repository.PatientRepository;

@Service
public class AdminServiceImpl implements IAdminService {

	@Autowired
	private AdminRepository adminRepository;

	@Autowired
	private DoctorRepository doctorRepository;

	@Autowired
	private PatientRepository patientRepository;

	@Autowired
	private AppointmentRepository appointmentRepository;

	@Override
	public Admin addAdmin(Admin admin) {
		return adminRepository.save(admin);
	}

	@Override
	public Doctor addDoctor(Doctor doctor) {
		return doctorRepository.save(doctor);
	}

	@Override
	public Patient addPatient(Patient patient) {
		return patientRepository.save(patient);
	}

	@Override
	public Appointment addAppointment(Appointment appointment) {
		return appointmentRepository.save(appointment);
	}

	@Override
	public boolean authenticateAdmin(String username, String password) {
		Admin admin = adminRepository.findByUsername(username);

		if (admin != null && admin.getPassword().equals(password)) {
			return true;
		}
		return false;
	}

	@Override
	public void logoutAdmin() {
		// TODO Auto-generated method stub

	}

}
