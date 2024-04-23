package com.oasis.domain.property;

import com.oasis.domain.property.enums.PropertyType;
import com.oasis.domain.property.enums.Tenure;

import java.util.Date;

public class Property {
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

    public Property() {}

    public Property(long siteId, String location, int price, PublicTransportDetails publicTransport, Date addedOn, String propertyType, Tenure tenure, int bedrooms, Integer size, Boolean hasGarden) {
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

    public long getSiteId() {
        return siteId;
    }

    public void setSiteId(long siteId) {
        this.siteId = siteId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public PublicTransportDetails getPublicTransport() {
        return publicTransport;
    }

    public void setPublicTransport(PublicTransportDetails publicTransport) {
        this.publicTransport = publicTransport;
    }

    public Date getAddedOn() {
        return addedOn;
    }

    public void setAddedOn(Date addedOn) {
        this.addedOn = addedOn;
    }

    public String getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }

    public Tenure getTenure() {
        return tenure;
    }

    public void setTenure(Tenure tenure) {
        this.tenure = tenure;
    }

    public int getRooms() {
        return bedrooms;
    }

    public void setRooms(int bedrooms) {
        this.bedrooms = bedrooms;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Boolean getHasGarden() {
        return hasGarden;
    }

    public void setHasGarden(Boolean hasGarden) {
        this.hasGarden = hasGarden;
    }
}
