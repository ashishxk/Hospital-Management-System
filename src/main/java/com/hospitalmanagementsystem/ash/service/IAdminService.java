package com.hospitalmanagementsystem.ash.service;

import com.hospitalmanagementsystem.ash.model.Admin;
import com.hospitalmanagementsystem.ash.model.Appointment;
import com.hospitalmanagementsystem.ash.model.Doctor;
import com.hospitalmanagementsystem.ash.model.Patient;

public interface IAdminService {

	Admin addAdmin(Admin admin);

	Doctor addDoctor(Doctor doctor);

	Patient addPatient(Patient patient);

	Appointment addAppointment(Appointment appointment);

	boolean authenticateAdmin(String username, String password);

	void logoutAdmin();

}
