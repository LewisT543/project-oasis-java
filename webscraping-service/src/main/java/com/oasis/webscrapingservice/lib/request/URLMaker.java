package com.oasis.webscrapingservice.lib.request;

import com.oasis.webscrapingservice.StaticURLs;

import java.util.LinkedHashMap;

public class URLMaker {

    public static String build(LinkedHashMap<String, String> baseArgs, LinkedHashMap<String, String> args, String baseUrl) {
        LinkedHashMap<String, String> updatedArgsMap = URLArgsParser.updateURLArgs(baseArgs, args);
        return URLArgsParser.buildURLArgs(baseUrl, updatedArgsMap);
    };

    LinkedHashMap<String, String> argsMap = new LinkedHashMap<>(){{
        put("searchType","SALE");
        put("locationIdentifier","REGION%5E904");
        put("insId","1");
        put("radius","0.0");
        put("_includeSSTC", "on");
        put("auction","false");
    }};
    LinkedHashMap<String, String> baseArgsMap = URLArgsParser.parseURLArgs(StaticURLs.RIGHTMOVE_SEARCH_ARGS_EMPTY);
    LinkedHashMap<String, String> updatedArgsMap = URLArgsParser.updateURLArgs(baseArgsMap, argsMap);
    String url = URLArgsParser.buildURLArgs(StaticURLs.RIGHTMOVE_SEARCH_URL, updatedArgsMap);

}
