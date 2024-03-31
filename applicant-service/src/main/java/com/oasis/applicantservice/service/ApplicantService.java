package com.oasis.applicantservice.service;

import com.oasis.applicantservice.model.ApplicantEntity;
import com.oasis.applicantservice.repo.ApplicantRepository;
import com.oasis.domain.mortgage.Applicant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ApplicantService {

    private final ApplicantRepository applicantRepository;

    @Autowired
    public ApplicantService(ApplicantRepository applicantRepository) {
        this.applicantRepository = applicantRepository;
    }

    public List<Applicant> getAllApplicants() {
        List<ApplicantEntity> applicantEntities = applicantRepository.findAll();
        return applicantEntities.stream()
                .map(ApplicantConverter::toDTO)
                .collect(Collectors.toList());
    }

    public Applicant getApplicantById(String id) {
        ApplicantEntity maybeApplicantEntity = applicantRepository.findById(id).orElse(null);
        return ApplicantConverter.toDTO(maybeApplicantEntity);
    }

    public Applicant saveApplicant(ApplicantEntity applicant) {
        ApplicantEntity savedApplicant = applicantRepository.save(applicant);
        return ApplicantConverter.toDTO(savedApplicant);
    }

    public void deleteApplicant(String id) {
        applicantRepository.deleteById(id);
    }
}

