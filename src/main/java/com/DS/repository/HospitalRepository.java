package com.DS.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.DS.model.Hospital;

public interface HospitalRepository extends JpaRepository<Hospital, Long> {

	List<Hospital> findByCityContaining(String city);

}
