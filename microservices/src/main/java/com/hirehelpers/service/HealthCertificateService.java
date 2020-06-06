package com.hirehelpers.service;


import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.hirehelpers.exception.FileStorageException;
import com.hirehelpers.exception.MyFileNotFoundException;
import com.hirehelpers.model.entity.HealthCertificate;
import com.hirehelpers.repository.HealthCertificateRepository;



@Service
public class HealthCertificateService {

    @Autowired
    private HealthCertificateRepository healthCertificateRepository;

    public HealthCertificate storeCertificate(MultipartFile file, int helperId, String validFrom, String validThrough) throws FileStorageException {
        // Normalize file name
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            // Check if the file's name contains invalid characters
            if(fileName.contains("..")) {
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }
            
            SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
            Date startDate = null;
            Date endDate = null;
			try {
				startDate = format.parse(validFrom);
				endDate = format.parse(validThrough);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    java.sql.Date start = new java.sql.Date(startDate.getTime());
		    java.sql.Date end = new java.sql.Date(endDate.getTime());


            HealthCertificate certificate = new HealthCertificate(fileName, file.getContentType(), file.getBytes(), start, end);
            certificate.setHelperId(helperId);

            return healthCertificateRepository.save(certificate);
        } catch (IOException ex) {
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
        }
    }

    public HealthCertificate getFile(String fileId, int helperId) throws MyFileNotFoundException {
        return healthCertificateRepository.findByIdAndHelperId(fileId, helperId)
                .orElseThrow(() -> new MyFileNotFoundException("File not found with id " + fileId));
    }
    
    public HealthCertificate getFileForHelper(int helperId) throws MyFileNotFoundException {
        return healthCertificateRepository.findByHelperId(helperId)
                .orElseThrow(() -> new MyFileNotFoundException("File not found for id " + helperId));
    }
}
