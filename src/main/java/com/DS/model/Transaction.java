package com.DS.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Transaction {

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

	@Column(name = "status")
	private String status;

	@Column(name = "type")
	private String type;

	@Column(name = "entity")
	private String entity;

	@Column(name = "amount")
	private String amount;

	@Column(name = "mode")
	private String mode;

	public Transaction() {

	}

	public Transaction(long patient, long doctor, long hospital, String status, String type, String entity,
			String amount, String mode) {
		this.patient = patient;
		this.doctor = doctor;
		this.hospital = hospital;
		this.status = status;
		this.type = type;
		this.entity = entity;
		this.amount = amount;
		this.mode = mode;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getEntity() {
		return entity;
	}

	public void setEntity(String entity) {
		this.entity = entity;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

}
