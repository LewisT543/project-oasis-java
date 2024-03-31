package com.oasis.applicantservice.controller;

import com.oasis.applicantservice.model.ApplicantEntity;
import com.oasis.applicantservice.response.ApplicantResponse;
import com.oasis.applicantservice.service.ApplicantService;
import com.oasis.domain.mortgage.Applicant;
import com.oasis.utils.ErrorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4173")
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
    public ResponseEntity<ApplicantResponse> getApplicantById(@PathVariable String id) {
        Applicant applicant = applicantService.getApplicantById(id);
        if (applicant == null) return Not_Found(id);
        return Success(applicant);
    }

    @PostMapping
    public ResponseEntity<ApplicantResponse> addApplicant(@RequestBody ApplicantEntity applicant) {
        Applicant newApplicant = applicantService.saveApplicant(applicant);
        return Success(newApplicant);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteApplicant(@PathVariable String id) {
        applicantService.deleteApplicant(id);
        return new ResponseEntity<>(id, HttpStatus.NO_CONTENT);
    }


    private static ResponseEntity<ApplicantResponse> Success(Applicant applicant) {
        return new ResponseEntity<>(new ApplicantResponse(applicant, null), HttpStatus.OK);
    }

    private static ResponseEntity<ApplicantResponse> Not_Found(String id) {
        return new ResponseEntity<>(new ApplicantResponse(null, ErrorUtils.notFoundError("Applicant", "Id", id)), HttpStatus.NOT_FOUND);
    }
}
