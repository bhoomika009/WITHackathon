package com.hirehelpers.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.hirehelpers.exception.FileStorageException;
import com.hirehelpers.exception.MyFileNotFoundException;
import com.hirehelpers.model.entity.HealthCertificate;
import com.hirehelpers.model.response.UploadCertificateResponse;
import com.hirehelpers.service.HealthCertificateService;


@RestController
public class HealthCertificateController {

    private static final Logger logger = LoggerFactory.getLogger(HealthCertificateController.class);

    @Autowired
    private HealthCertificateService healthCertificateService;

    @PostMapping("/uploadCertificate")
    public UploadCertificateResponse uploadFile(@RequestParam("helperId") int helperId, @RequestParam("file") MultipartFile file,
    		@RequestParam("validFrom") String validFrom, @RequestParam("validThrough") String validThrough)
    		  {
        HealthCertificate certificate = null;
		try {
			certificate = healthCertificateService.storeCertificate(file, helperId, validFrom, validThrough );
		} catch (FileStorageException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String helper_Id = Integer.toString(certificate.getHelperId());

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadCertificate/")
                .path(certificate.getId())
                .path(helper_Id)
                .toUriString();

        return new UploadCertificateResponse(certificate.getFileName(), fileDownloadUri,
                file.getContentType(), file.getSize());
    }


    @GetMapping("/downloadCertificate/{helperId}")
    public ResponseEntity<Resource> downloadFile(@PathVariable int  helperId) {
    	HealthCertificate certificate = null;
		try {
			certificate = healthCertificateService.getFileForHelper(helperId);
		} catch (MyFileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        return ResponseEntity.ok()
	                .contentType(MediaType.parseMediaType(certificate.getFileType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + certificate.getFileName() + "\"")
                .body(new ByteArrayResource(certificate.getData()));
    }

}
