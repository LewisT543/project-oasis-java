package com.oasis.propertyservice.service;

import com.oasis.domain.property.Property;
import com.oasis.propertyservice.model.PropertyEntity;
import com.oasis.propertyservice.repo.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PropertyService {

    private final PropertyRepository propertyRepository;

    @Autowired
    public PropertyService(PropertyRepository propertyRepository) {
        this.propertyRepository = propertyRepository;
    }

    public List<Property> getAllProperties() {
        List<PropertyEntity> propertyEntities = propertyRepository.findAll();
        System.out.println("getting properties");
        return propertyEntities.stream()
                .map(PropertyConverter::toDTO)
                .collect(Collectors.toList());
    }

    public Property createProperty(Property property) {
        PropertyEntity entity = PropertyConverter.toEntity(property);
        PropertyEntity savedEntity = propertyRepository.save(entity);
        return PropertyConverter.toDTO(savedEntity);
    }
}
