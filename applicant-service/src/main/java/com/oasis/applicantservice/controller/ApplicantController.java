package com.oasis.applicantservice.controller;

import com.oasis.applicantservice.service.ApplicantService;
import com.oasis.domain.mortgage.Applicant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/applicants")
public class ApplicantController {

    private final ApplicantService applicantService;

    @Autowired
    public ApplicantController(ApplicantService applicantService) {
        this.applicantService = applicantService;
    }

    @GetMapping
    public ResponseEntity<List<Applicant>> getAllApplicants() {
        List<Applicant> applicants = applicantService.getAllApplicants();
        return new ResponseEntity<>(applicants, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Applicant> getApplicantById(@PathVariable String id) {
        Applicant applicant = applicantService.getApplicantById(id);
        return new ResponseEntity<>(applicant, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Applicant> addApplicant(@RequestBody Applicant applicant) {
        Applicant newApplicant = applicantService.saveApplicant(applicant);
        return new ResponseEntity<>(newApplicant, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteApplicant(@PathVariable String id) {
        applicantService.deleteApplicant(id);
        return new ResponseEntity<>(id, HttpStatus.NO_CONTENT);
    }
}
