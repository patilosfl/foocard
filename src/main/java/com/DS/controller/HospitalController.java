package com.DS.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import com.DS.service.CSVService;
import com.DS.service.CSVHelper;
import com.DS.model.Hospital;
import com.DS.service.ResponseMessage;

import com.DS.repository.HospitalRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class HospitalController {

	@GetMapping("/uploadFile")
	public String index() {
		return "Greetings from Spring Boot!";
	}

	@Autowired
	CSVService fileService;

	@Autowired
	HospitalRepository hospitalRepository;

	@PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
		String message = "";
		if (CSVHelper.hasCSVFormat(file)) {
			try {
				fileService.save(file);
				message = "Uploaded the file successfully: " + file.getOriginalFilename();
				return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
			} catch (Exception e) {
				message = "Could not upload the file: " + file.getOriginalFilename() + "!";
				return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
			}
		}
		message = "Please upload a csv file!";
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message));
	}

	@GetMapping("/hospitals")
	public ResponseEntity<List<Hospital>> getAllHospitals(@RequestParam(required = false) String city) {
		try {

			List<Hospital> hospitals;

			if (city == null) {
				hospitals = fileService.getAllHospitals();
			} else {
				hospitals = fileService.getAllHospitals(city);
			}

			if (hospitals.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(hospitals, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/hospitals/{id}")
	public ResponseEntity<Hospital> getHospitalById(@PathVariable("id") long id) {
		Optional<Hospital> hospitalData = hospitalRepository.findById(id);
		if (hospitalData.isPresent()) {
			return new ResponseEntity<>(hospitalData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
