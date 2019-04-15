package com.course.api.controller;

import com.course.api.dto.CertificateDTO;
import com.course.api.entity.Certificate;
import com.course.api.service.CertificateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/certificate")
public class CertificateController {


    @Autowired
    private CertificateService certificateService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<Certificate>> getAllCertificate() {
        try {
            List<Certificate> certificates = certificateService.getAll();
            if (certificates.isEmpty()) return new ResponseEntity(HttpStatus.NO_CONTENT);
            return new ResponseEntity<List<Certificate>>(certificates, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Certificate> getCertificateById(@PathVariable(name = "id") Integer id) {
        try {
            Certificate certificate = certificateService.getCertificateById(id);
            if (certificate==null) return new ResponseEntity(HttpStatus.NO_CONTENT);
            return new ResponseEntity<Certificate>(certificate, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<Certificate> addCertificate(@RequestBody CertificateDTO certificateDTO) {
        try {
            if (certificateDTO == null) return new ResponseEntity(HttpStatus.NO_CONTENT);
            return new ResponseEntity<Certificate>(certificateService.addCertificate(certificateDTO), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public ResponseEntity<Certificate> updateCertificate(@PathVariable(name = "id") Integer id, @RequestBody CertificateDTO certificateDTO) {
        try {
            Certificate curCertificate = certificateService.getCertificateById(id);
            if (curCertificate == null) return new ResponseEntity(HttpStatus.NOT_FOUND);
            return new ResponseEntity<Certificate>(certificateService.updateCertificate(certificateDTO, id), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public boolean deleteCertificate(@PathVariable(name = "id") Integer id) {
        try {
            Certificate certificate = certificateService.getCertificateById(id);
            if (certificate == null) return false;
            certificateService.removeCertificate(certificate);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
