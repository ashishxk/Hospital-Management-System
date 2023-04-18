package com.hospitalmanagementsystem.ash.service;

import java.util.List;

import com.hospitalmanagementsystem.ash.model.Appointment;

public interface IAppointmentService {

	Appointment addAppointment(Appointment appointment);
	
	List<Appointment> getAllAppointments();

	void deleteAppointmentById(Long id);

	Appointment updateAppointment(Long id, Appointment appointment);

	Appointment getAppointmentById(long id);
}
