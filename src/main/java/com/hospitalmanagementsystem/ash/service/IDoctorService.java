package com.hospitalmanagementsystem.ash.service;

import java.util.List;
import com.hospitalmanagementsystem.ash.model.Doctor;

public interface IDoctorService {

	Doctor addDoctor(Doctor doctor);

	List<Doctor> getAllDoctors();

	void deleteDoctor(Long id);

	void updateDoctor(Doctor doctor);

	Doctor getDoctorById(Long id);
}
