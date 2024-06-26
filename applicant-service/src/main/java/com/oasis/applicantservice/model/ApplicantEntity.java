package com.oasis.applicantservice.model;

import com.oasis.domain.mortgage.Expenses;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@Document(collection = "applicants")
public class ApplicantEntity {
    @Id
    private String id;

    private String name;
    private double salary;
    private double netMonthly;
    private Expenses expenses;

    public ApplicantEntity() {}

    public ApplicantEntity(String name, double salary, double netMonthly, Expenses expenses) {
        this.name = name;
        this.salary = salary;
        this.netMonthly = netMonthly;
        this.expenses = expenses;
    }
}
