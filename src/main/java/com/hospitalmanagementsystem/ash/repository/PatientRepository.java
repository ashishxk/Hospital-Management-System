package com.hospitalmanagementsystem.ash.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.hospitalmanagementsystem.ash.model.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long>{

}
