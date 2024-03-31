package com.oasis.applicantservice.service;

import com.oasis.applicantservice.model.ApplicantEntity;
import com.oasis.domain.mortgage.Applicant;

public class ApplicantConverter {
    public static Applicant toDTO(ApplicantEntity entity) {
        if (entity == null) return null;
        return new Applicant(
                entity.getId(),
                entity.getName(),
                entity.getSalary(),
                entity.getNetMonthly(),
                entity.getExpenses()
        );
    }

    public static ApplicantEntity toEntity(Applicant dto) {
        if (dto == null) return null;
        return new ApplicantEntity(
                dto.getId(),
                dto.getName(),
                dto.getSalary(),
                dto.getNetMonthly(),
                dto.getExpenses()
        );
    }
}
