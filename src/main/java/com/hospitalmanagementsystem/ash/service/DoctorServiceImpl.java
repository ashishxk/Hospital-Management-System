package com.hospitalmanagementsystem.ash.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hospitalmanagementsystem.ash.model.Doctor;
import com.hospitalmanagementsystem.ash.repository.DoctorRepository;

@Service
public class DoctorServiceImpl implements IDoctorService {

	@Autowired
	private DoctorRepository doctorRepository;

	@Override
	public Doctor addDoctor(Doctor doctor) {
		return doctorRepository.save(doctor);
	}

	@Override
	public List<Doctor> getAllDoctors() {
		return doctorRepository.findAll();
	}

	@Override
	public void deleteDoctor(Long id) {
		doctorRepository.deleteById(id);
	}

	@Override
	public void updateDoctor(Doctor doctor) {
		doctorRepository.save(doctor);
	}

	@Override
	public Doctor getDoctorById(Long id) {
		Optional<Doctor> optional = doctorRepository.findById(id);
		Doctor doctor = null;
		if (optional.isPresent()) {
			doctor = optional.get();
		} else {
			throw new RuntimeException();
		}
		return doctor;
	}

}
