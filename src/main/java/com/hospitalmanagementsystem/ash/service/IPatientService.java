package com.hospitalmanagementsystem.ash.service;

import java.util.List;

import com.hospitalmanagementsystem.ash.model.Patient;

public interface IPatientService {

	Patient addPatient(Patient patient);

	List<Patient> getAllPatients();

	void deletePatient(Long id);

	void updatePatient(Patient patient);

	Patient getPatientById(Long id);
}
