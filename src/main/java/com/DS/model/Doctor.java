package com.DS.model;

import javax.persistence.*;

@Entity
@Table(name = "doctors")

public class Doctor {

	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private long id;

	@Column(name = "username")
	private String username;

	@Column(name = "email")
	private String email;

	@Column(name = "education")
	private String education;

	@Column(name = "specilization")
	private String specilization;

	@Column(name = "mobile_no")
	private String mobile_no;

	@Column(name = "hospital_name")
	private String hospital_name;

	@Column(name = "address")
	private String address;

	@Column(name = "pincode")
	private String pincode;

	@Column(name = "date")
	private String date;

	public Doctor() {

	}

	public Doctor(String username, String email, String education, String specilization, String mobile_no,
			String hospital_name, String address, String pincode) {		
		this.username = username;
		this.email = email;
		this.education = education;
		this.specilization = specilization;
		this.mobile_no = mobile_no;
		this.hospital_name = hospital_name;
		this.address = address;
		this.pincode = pincode;
			

	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getSpecilization() {
		return specilization;
	}

	public void setSpecilization(String specilization) {
		this.specilization = specilization;
	}

	public String getMobile_no() {
		return mobile_no;
	}

	public void setMobile_no(String mobile_no) {
		this.mobile_no = mobile_no;
	}

	public String getHospital_name() {
		return hospital_name;
	}

	public void setHospital_name(String hospital_name) {
		this.hospital_name = hospital_name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
