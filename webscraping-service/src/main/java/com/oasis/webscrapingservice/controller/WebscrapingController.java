package com.oasis.webscrapingservice.controller;

import com.oasis.domain.property.Property;
import com.oasis.webscrapingservice.service.PropertyScrapingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4173")
@RequestMapping("/api/scraper")
public class WebscrapingController {

    private final PropertyScrapingService propertyScrapingService;

    @Autowired
    public WebscrapingController(PropertyScrapingService propertyScrapingService) { this.propertyScrapingService = propertyScrapingService; }

    @GetMapping("/rightmove/getAllProperties/{region}")
    public ResponseEntity<List<Property>> scrapeRightmove(@PathVariable String region) {
        List<Property> properties = propertyScrapingService.getByRegion(region);
        return new ResponseEntity<>(properties, HttpStatus.OK);
    }

//    @GetMapping("/scrapeZoopla")
//    public String scrapeZoopla() {
//        return propertyScrapingService.scrape();
//    }
}
