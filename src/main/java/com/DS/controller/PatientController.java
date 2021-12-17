package com.DS.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.DS.model.Patient;
import com.DS.repository.PatientRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class PatientController {

	@Autowired
	PatientRepository patientRepository;

	@Autowired
	private PasswordEncoder bcryptEncoder;

	@GetMapping("/getPatients")
	public ResponseEntity<List<Patient>> getPatients() {
		try {
			List<Patient> patient = new ArrayList<Patient>();
			patientRepository.findAll().forEach(patient::add);

			if (patient.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(patient, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/registerPatient")
	public ResponseEntity<Patient> registerPatient(@RequestBody Patient patient) {
		try {
			Patient _patient = patientRepository.save(new Patient(patient.getFirstname(), patient.getLastname(),bcryptEncoder.encode(patient.getPassword()), patient.getEmail(), patient.getMobile()));
			return new ResponseEntity<>(_patient, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
