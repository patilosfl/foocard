package com.DS.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Rating {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private long id;

	@Column(name = "patient")
	private long patient;

	@Column(name = "doctor")
	private long doctor;

	@Column(name = "hospital")
	private long hospital;

	@Column(name = "rating")
	private String rating;

	@Column(name = "comments")
	private String comments;

	public Rating() {

	}

	public Rating(long patient, long doctor, long hospital, String rating, String comments, String payment) {
		this.patient = patient;
		this.doctor = doctor;
		this.hospital = hospital;
		this.rating = rating;
		this.comments = comments;

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getPatient() {
		return patient;
	}

	public void setPatient(long patient) {
		this.patient = patient;
	}

	public long getDoctor() {
		return doctor;
	}

	public void setDoctor(long doctor) {
		this.doctor = doctor;
	}

	public long getHospital() {
		return hospital;
	}

	public void setHospital(long hospital) {
		this.hospital = hospital;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

}
