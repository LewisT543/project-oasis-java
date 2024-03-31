package com.oasis.applicantservice.response;

import com.oasis.domain.mortgage.Applicant;

public class ApplicantResponse {
    private Applicant applicant;
    private String errorMessage;

    public ApplicantResponse(Applicant applicant, String errorMessage) {
        this.applicant = applicant;
        this.errorMessage = errorMessage;
    }

    public Applicant getApplicant() {
        return applicant;
    }

    public void setApplicant(Applicant applicant) {
        this.applicant = applicant;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
