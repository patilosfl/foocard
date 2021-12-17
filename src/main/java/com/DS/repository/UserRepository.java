package com.DS.repository;
import com.DS.model.Patient;

import org.springframework.data.repository.CrudRepository;
public interface UserRepository extends CrudRepository<Patient, Integer> {
	Patient findByEmail(String email);
	Patient findByMobile(String mobile);
	Patient findByEmailOrMobile(String email, String mobile);
}