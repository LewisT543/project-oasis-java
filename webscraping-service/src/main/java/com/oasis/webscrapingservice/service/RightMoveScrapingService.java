package com.oasis.webscrapingservice.service;

import com.oasis.domain.property.Property;
import com.oasis.webscrapingservice.lib.Webscraper;
import com.oasis.webscrapingservice.lib.request.URLArgsParser;
import com.oasis.webscrapingservice.lib.request.URLMaker;
import com.oasis.webscrapingservice.lib.response.parseFns.DataParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.oasis.webscrapingservice.StaticURLs.*;

@Service
public class RightMoveScrapingService implements PropertyScrapingService {
    private final Webscraper<Property> webscraper;

    @Autowired
    public RightMoveScrapingService() {
        this.webscraper = new Webscraper<>();
    }
    @Override
    public List<Property> getByRegion(String region) {
        String url = URLMaker.build(
                URLArgsParser.parseURLArgs(RIGHTMOVE_SEARCH_ARGS_EMPTY),
                RIGHTMOVE_SEARCH_ARGS_BASE,
                RIGHTMOVE_SEARCH_URL
                );
        List<Property> properties = webscraper.getPageOf(url, DataParser.rightMoveSearchCleanFn);
        return null;
    }
}
