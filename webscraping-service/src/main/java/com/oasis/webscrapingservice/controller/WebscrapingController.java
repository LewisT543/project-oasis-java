package com.oasis.webscrapingservice.controller;

import com.oasis.webscrapingservice.service.PropertyScrapingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4173")
@RequestMapping("/api/scraper")
public class WebscrapingController {

    private final PropertyScrapingService propertyScrapingService;

    @Autowired
    public WebscrapingController(PropertyScrapingService propertyScrapingService) { this.propertyScrapingService = propertyScrapingService; }

    @GetMapping("/scrapeRightmove")
    public String scrapeRightmove() {
        System.out.println();
        return propertyScrapingService.scrape();
    }

    @GetMapping("/scrapeZoopla")
    public String scrapeZoopla() {
        return propertyScrapingService.scrape();
    }
}
