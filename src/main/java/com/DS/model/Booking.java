package com.DS.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Booking {

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

	@Column(name = "distance")
	private String distance;

	@Column(name = "schedule")
	private String schedule;

	@Column(name = "status")
	private String status;

	@Column(name = "payment")
	private String payment;

	public Booking() {

	}

	public Booking(long patient, long doctor, long hospital, String distance, String schedule, String status,
			String payment) {
		this.patient = patient;
		this.doctor = doctor;
		this.hospital = hospital;
		this.distance = distance;
		this.schedule = schedule;

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

	public String getDistance() {
		return distance;
	}

	public void setDistance(String distance) {
		this.distance = distance;
	}

	public String getSchedule() {
		return schedule;
	}

	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}
}
