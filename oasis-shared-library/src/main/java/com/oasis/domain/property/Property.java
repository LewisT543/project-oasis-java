package com.oasis.domain.property;

import com.oasis.domain.property.enums.PropertyType;
import com.oasis.domain.property.enums.Tenure;

import java.util.Date;

public class Property {
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

    public Property() {}

    public Property(String id, Location location, int price, PublicTransportDetails publicTransport, Date addedOn, PropertyType propertyType, Tenure tenure, Rooms rooms, Integer size, Boolean hasGarden) {
        this.id = id;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
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

    public PropertyType getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(PropertyType propertyType) {
        this.propertyType = propertyType;
    }

    public Tenure getTenure() {
        return tenure;
    }

    public void setTenure(Tenure tenure) {
        this.tenure = tenure;
    }

    public Rooms getRooms() {
        return rooms;
    }

    public void setRooms(Rooms rooms) {
        this.rooms = rooms;
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
