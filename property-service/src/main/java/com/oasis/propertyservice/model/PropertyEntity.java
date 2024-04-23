package com.oasis.propertyservice.model;

import com.oasis.domain.property.PublicTransportDetails;
import com.oasis.domain.property.Rooms;
import com.oasis.domain.property.enums.PropertyType;
import com.oasis.domain.property.enums.Tenure;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@AllArgsConstructor
@Document(collection = "properties")
public class PropertyEntity {
    @Id
    private String id;

    private long siteId;
    private String location;
    private int price;
    private PublicTransportDetails publicTransport;
    private Date addedOn;
    private String propertyType;
    private Tenure tenure;
    private int bedrooms;
    private Integer size;
    private Boolean hasGarden;

    public PropertyEntity() {}

    public PropertyEntity(long siteId, String location, int price, PublicTransportDetails publicTransport, Date addedOn, String propertyType, Tenure tenure, int bedrooms, Integer size, Boolean hasGarden) {
        this.siteId = siteId;
        this.location = location;
        this.price = price;
        this.publicTransport = publicTransport;
        this.addedOn = addedOn;
        this.propertyType = propertyType;
        this.tenure = tenure;
        this.bedrooms = bedrooms;
        this.size = size;
        this.hasGarden = hasGarden;
    }
}