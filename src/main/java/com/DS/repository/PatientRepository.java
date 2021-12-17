package com.DS.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.DS.model.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long>{
	

}
