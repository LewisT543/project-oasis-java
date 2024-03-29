package com.oasis.applicantservice.repo;

import com.oasis.applicantservice.model.ApplicantEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "applicants", path = "applicants")
public interface ApplicantRepository extends MongoRepository<ApplicantEntity, String> {
}
