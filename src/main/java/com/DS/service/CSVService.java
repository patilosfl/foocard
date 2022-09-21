package com.DS.service;

import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;

//import com.DS.service.CSVHelper;
import com.DS.model.Hospital;
import com.DS.repository.HospitalRepository;

@Service
public class CSVService {

	@Autowired
	HospitalRepository repository;

	public void save(MultipartFile file) {
		try {
			List<Hospital> hospitals = CSVHelper.csvToHospitals(file.getInputStream());
			repository.saveAll(hospitals);
		} catch (IOException e) {
			throw new RuntimeException("fail to store csv data: " + e.getMessage());
		}
	}
	
	
	public List<Hospital> getAllHospitals() {
		return repository.findAll();
	}


	public List<Hospital> getAllHospitals(String city) {
		List<Hospital> hospitals = new ArrayList<Hospital>();
		repository.findByCityContaining(city).forEach(hospitals::add);
		return hospitals;
	}

}
