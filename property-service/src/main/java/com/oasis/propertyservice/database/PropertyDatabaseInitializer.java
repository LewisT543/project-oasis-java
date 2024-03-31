package com.oasis.propertyservice.database;

import com.oasis.domain.property.*;
import com.oasis.domain.property.enums.PropertyType;
import com.oasis.domain.property.enums.StationType;
import com.oasis.domain.property.enums.Tenure;
import com.oasis.propertyservice.model.PropertyEntity;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Date;

@Component
public class PropertyDatabaseInitializer {

    private final MongoTemplate mongoTemplate;

    @Autowired
    public PropertyDatabaseInitializer(MongoTemplate mongoTemplate) {
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

    private void addDefaultPropertyIfNotExists() {
        if (mongoTemplate.findAll(PropertyEntity.class, "properties").isEmpty()) {
            mongoTemplate.save(createDefaultProperty(), "properties");
            System.out.println("Added default property to the 'properties' collection.");
        } else {
            System.out.println("Default property already exists in the 'properties' collection.");
        }
    }

    private PropertyEntity createDefaultProperty() {
        return new PropertyEntity(
                new Location("road", "region", "city", "postcode"),
                300000,
                new PublicTransportDetails(Arrays.asList(
                        new StationDetail("stationName1", StationType.TRAIN, 1.2),
                        new StationDetail("stationName2", StationType.BUS, 0.6)
                )),
                new Date(),
                PropertyType.SEMI_DETACHED,
                Tenure.FREEHOLD,
                new Rooms(5, 2, false),
                2500,
                true
        );
    }

    @PostConstruct
    public void initialize() {
        checkDatabase();
        createCollectionIfNotExists("properties");
        addDefaultPropertyIfNotExists();
        System.out.println("Completed DB-Initializer tasks");
    }
}
