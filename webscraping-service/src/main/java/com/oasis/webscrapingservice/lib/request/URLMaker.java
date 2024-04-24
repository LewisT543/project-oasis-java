package com.oasis.webscrapingservice.lib.request;

import com.oasis.webscrapingservice.lib.request.updateFns.UrlUpdateFn;

import java.util.LinkedHashMap;

public class URLMaker {
    public static String build(LinkedHashMap<String, String> baseArgs, LinkedHashMap<String, String> args, String baseUrl) {
        LinkedHashMap<String, String> updatedArgsMap = URLArgsParser.updateURLArgs(baseArgs, args);
        return URLArgsParser.buildURLArgs(baseUrl, updatedArgsMap);
    }

    public static UrlUpdateFn updateRightMoveUrl = url -> {
        int index = url.indexOf("&sortType=6");
        if (index == -1) throw new RuntimeException("no sort type found - base params not applying!");
        return url.replaceFirst("&sortType=6", "&sortType=6&index=" + index);
    };

}
