package com.DS.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.jdbc.core.JdbcTemplate;

import com.DS.model.Doctor;
import com.DS.repository.DoctorRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")

public class DoctorController {
	@Autowired
	DoctorRepository doctorRepository;

	@GetMapping("/getAllDoctors")
	public ResponseEntity<List<Doctor>> getAllDoctors(@RequestParam(required = false) String username) {
		try {
			List<Doctor> doctor = new ArrayList<Doctor>();

			if (username == null)
				doctorRepository.findAll().forEach(doctor::add);
			else
				doctorRepository.findByUsernameContaining(username).forEach(doctor::add);

			if (doctor.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(doctor, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@GetMapping("/registerDoctor")
	public void updateDoctorDetails() {

		String sql = "INSERT INTO doctors (username,email,education,specilization,mobile_no,hospital_name,address,pincode) VALUES ('pravin','pravin@gmail.com','MBBS','dentist','9421421323','adhar','kolhapur','461519')";
		int rows = jdbcTemplate.update(sql);
		if (rows > 0) {
			System.out.println("A new row has been inserted.");
		}
	}
}


