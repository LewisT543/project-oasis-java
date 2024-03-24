package com.oasis.propertyservice.repo;

import com.oasis.propertyservice.model.PropertyEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "properties", path = "properties")
public interface PropertyRepository extends MongoRepository<PropertyEntity, String> {

}
