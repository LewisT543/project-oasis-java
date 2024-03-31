package com.oasis.applicantservice.db;

import com.oasis.applicantservice.model.ApplicantEntity;
import com.oasis.domain.mortgage.Expenses;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

@Component
public class ApplicantDatabaseInitializer {

    private final MongoTemplate mongoTemplate;

    @Autowired
    public ApplicantDatabaseInitializer(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    private void checkDatabase() {
        String dbname = mongoTemplate.getDb().getName();
        System.out.println("Using Database: " + dbname);
    }

    public void createCollectionIfNotExists(String collectionName) {
        if (!mongoTemplate.collectionExists(collectionName)) {
            mongoTemplate.createCollection(collectionName);
            System.out.println("Created collection: " + collectionName);
        } else {
            System.out.println("Collection already exists: " + collectionName);
        }
    }

    private void addDefaultApplicantIfNotExists() {
        if (mongoTemplate.findAll(ApplicantEntity.class, "applicants").isEmpty()) {
            mongoTemplate.save(createDefaultApplicant(), "applicants");
            System.out.println("Added default applicant to the 'applicants' collection.");
        } else {
            System.out.println("Default applicant already exists in the 'applicants' collection.");
        }
    }

    private ApplicantEntity createDefaultApplicant() {
        return new ApplicantEntity(
                "lewis",
                50000.00,
                500.00,
                new Expenses(100.0, 100.0, 100.0, 100.0, 100.0)
        );
    }

    @PostConstruct
    public void initialize() {
        checkDatabase();
        createCollectionIfNotExists("applicants");
        addDefaultApplicantIfNotExists();
        System.out.println("Completed DB-Initializer tasks");
    }
}
