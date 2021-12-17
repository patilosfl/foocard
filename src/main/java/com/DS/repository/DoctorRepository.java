package com.DS.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.DS.model.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long>{
	
	List<Doctor> findByEmail(String email);
	List<Doctor> findByUsernameContaining(String username);
	

}
