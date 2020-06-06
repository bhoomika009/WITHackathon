package com.hirehelpers.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hirehelpers.model.entity.HealthCertificate;

@Repository
public interface HealthCertificateRepository extends JpaRepository<HealthCertificate, String> {
	
	public Optional<HealthCertificate> findByIdAndHelperId (String fileId, int helperId);
	
	public Optional<HealthCertificate> findByHelperId (int helperId);
	
} 