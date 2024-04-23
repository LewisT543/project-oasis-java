package com.oasis.webscrapingservice.service;

import com.oasis.domain.property.Property;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PropertyScrapingService {
    List<Property> getByRegion(String region);
}