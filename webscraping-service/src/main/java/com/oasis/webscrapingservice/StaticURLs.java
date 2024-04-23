package com.oasis.webscrapingservice;

import java.util.LinkedHashMap;

public class StaticURLs {
    public static final String RIGHTMOVE_SEARCH_URL = "https://www.rightmove.co.uk/property-for-sale/find.html?";
    public static final String RIGHTMOVE_SEARCH_ARGS_EMPTY = "https://www.rightmove.co.uk/property-for-sale/find.html?searchType=&locationIdentifier=&insId=&radius=&minPrice=&maxPrice=&minBedrooms=&maxBedrooms=&displayPropertyType=&maxDaysSinceAdded=&_includeSSTC=&sortByPriceDescending=&primaryDisplayPropertyType=&secondaryDisplayPropertyType=&oldDisplayPropertyType=&oldPrimaryDisplayPropertyType=&newHome=&auction=";
    public static final LinkedHashMap<String, String> RIGHTMOVE_SEARCH_ARGS_BASE = new LinkedHashMap<>(){{
        put("searchType","SALE");
        put("locationIdentifier","REGION%5E904");
        put("sortType", "6");
        put("insId","1");
        put("radius","0.0");
        put("_includeSSTC", "on");
        put("auction","false");
    }};
    public static String RIGHTMOVE_PROPERTY_URL(long propertyId) { return "https://www.rightmove.co.uk/properties/"+ propertyId + "#/?channel=RES_BUY"; }
}
