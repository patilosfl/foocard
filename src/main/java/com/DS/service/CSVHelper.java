package com.DS.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
//import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.multipart.MultipartFile;

import com.DS.model.Hospital;

public class CSVHelper {

	public static String TYPE = "text/csv";
	static String[] HEADERs = { "name", "address", "city", "state", "ppn" };

	public static boolean hasCSVFormat(MultipartFile file) {
		if (!TYPE.equals(file.getContentType())) {
			return false;
		}
		return true;
	}

	public static List<Hospital> csvToHospitals(InputStream is) {
		try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
				CSVParser csvParser = new CSVParser(fileReader,
						CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {
			List<Hospital> hospitals = new ArrayList<Hospital>();
			Iterable<CSVRecord> csvRecords = csvParser.getRecords();
			for (CSVRecord csvRecord : csvRecords) {
				Hospital hospital = new Hospital(

						csvRecord.get("name"),
						csvRecord.get("address"),
						csvRecord.get("city"),
						csvRecord.get("state"),
						csvRecord.get("ppn")
						
						);
				hospitals.add(hospital);
			}
			return hospitals;
		} catch (IOException e) {
			throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
		}
	}

}
