package com.oasis.webscrapingservice.service;

import com.oasis.webscrapingservice.lib.RightMoveUrlMaker;
import org.springframework.stereotype.Service;

@Service
public class PropertyScrapingService {


    public String scrape() {
        // Logic to scrape data from both Rightmove and Zoopla
        String rightmoveData = scrapeRightmove();
        String zooplaData = scrapeZoopla();

        return "Scraped data from Rightmove: " + rightmoveData + "\n"
               + "Scraped data from Zoopla: " + zooplaData;
    }

    public String scrapeRightmove() {
        RightMoveUrlMaker urlMaker = new RightMoveUrlMaker("https://www.rightmove.co.uk/property-for-sale/find.html?locationIdentifier=");
        String url = urlMaker.makeRightMoveUrl("REGION%5E904");
        return "Data from Rightmove";
    }

    private String scrapeZoopla() {
        // Logic to scrape data from Zoopla
        return "Data from Zoopla";
    }
}
