package com.oasis.webscrapingservice.lib;

import com.oasis.domain.property.Property;
import com.oasis.webscrapingservice.StaticURLs;
import com.oasis.webscrapingservice.lib.request.URLArgsParser;
import com.oasis.webscrapingservice.lib.request.URLMaker;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;

import static com.oasis.webscrapingservice.StaticURLs.*;
import static com.oasis.webscrapingservice.lib.response.parseFns.DataParser.rightMoveSearchCleanFn;

public class WebscraperTests {

    @Test
    void tester() throws IOException {
        LinkedHashMap<String, String> argsMap = new LinkedHashMap<>(){{
            put("searchType","SALE");
            put("locationIdentifier","REGION%5E904");
            put("sortType", "6");
            put("includeSSTC", "false");
            put("auction","false");
        }};
//        LinkedHashMap<String, String> baseArgsMap = URLArgsParser.parseURLArgs(StaticURLs.RIGHTMOVE_SEARCH_ARGS_EMPTY);
//        LinkedHashMap<String, String> updatedArgsMap = URLArgsParser.updateURLArgs(baseArgsMap, argsMap);
//        String url = URLArgsParser.buildURLArgs(StaticURLs.RIGHTMOVE_SEARCH_URL, updatedArgsMap);
        String url2 = URLMaker.build(
                URLArgsParser.parseURLArgs(RIGHTMOVE_SEARCH_ARGS_EMPTY),
                RIGHTMOVE_SEARCH_ARGS_BASE,
                RIGHTMOVE_SEARCH_URL
        );
        Webscraper<Property> ws = new Webscraper<>();
        List<Property> res = ws.getPageOf(url2 ,rightMoveSearchCleanFn);
        String f = "final";
    }

}
