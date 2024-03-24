package com.oasis.propertyservice.model;

import com.oasis.domain.property.Location;
import com.oasis.domain.property.PublicTransportDetails;
import com.oasis.domain.property.Rooms;
import com.oasis.domain.property.enums.PropertyType;
import com.oasis.domain.property.enums.Tenure;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@AllArgsConstructor
@Document(collection = "properties")
public class PropertyEntity {
    @Id
    private String id;

    private Location location;
    private int price;
    private PublicTransportDetails publicTransport;
    private Date addedOn;
    private PropertyType propertyType;
    private Tenure tenure;
    private Rooms rooms;
    private Integer size;
    private Boolean hasGarden;

    public PropertyEntity() {}

    public PropertyEntity(Location location, int price, PublicTransportDetails publicTransport, Date addedOn, PropertyType propertyType, Tenure tenure, Rooms rooms, Integer size, Boolean hasGarden) {
        this.location = location;
        this.price = price;
        this.publicTransport = publicTransport;
        this.addedOn = addedOn;
        this.propertyType = propertyType;
        this.tenure = tenure;
        this.rooms = rooms;
        this.size = size;
        this.hasGarden = hasGarden;
    }
}