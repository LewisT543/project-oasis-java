package com.oasis.propertyservice.service;

import com.oasis.domain.property.Property;
import com.oasis.propertyservice.model.PropertyEntity;

public class PropertyConverter {
    public static Property toDTO(PropertyEntity entity) {
        return new Property(
                entity.getSiteId(),
                entity.getLocation(),
                entity.getPrice(),
                entity.getPublicTransport(),
                entity.getAddedOn(),
                entity.getPropertyType(),
                entity.getTenure(),
                entity.getBedrooms(),
                entity.getSize(),
                entity.getHasGarden()
        );
    }

    public static PropertyEntity toEntity(Property dto) {
        return new PropertyEntity(
                dto.getSiteId(),
                dto.getLocation(),
                dto.getPrice(),
                dto.getPublicTransport(),
                dto.getAddedOn(),
                dto.getPropertyType(),
                dto.getTenure(),
                dto.getRooms(),
                dto.getSize(),
                dto.getHasGarden()
        );
    }
}
