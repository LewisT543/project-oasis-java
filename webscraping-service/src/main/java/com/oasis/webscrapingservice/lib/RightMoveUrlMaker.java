package com.oasis.webscrapingservice.lib;

import com.oasis.webscrapingservice.domain.UrlMakerPropMapArgs;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class RightMoveUrlMaker {
    private final String baseUrl;
    private final LinkedHashMap<String, String> basePropertiesMap;
    private final LinkedHashMap<String, String> extraPropertiesMap;

    private static final LinkedHashMap<String, String> DEFAULT_basePropertiesMap = new LinkedHashMap<>() {{
        put("propertyTypes", "");
        put("mustHave", "");
        put("dontShow", "");
        put("furnishTypes", "");
        put("keywords", "");
    }};

    private static final LinkedHashMap<String, String> DEFAULT_extraPropertiesMap = new LinkedHashMap<>() {{
        put("maxBedrooms", "");
        put("minBedrooms", "");
        put("maxPrice", "");
        put("minPrice", "");
        put("includeSSTC", "");
        put("maxDaysSinceAdded", "");
    }};

    public RightMoveUrlMaker(String baseUrl) {
        this(baseUrl, new UrlMakerPropMapArgs(null, null));
    }

    public RightMoveUrlMaker(String baseUrl, UrlMakerPropMapArgs mapArgs) {
        this.baseUrl = baseUrl;
        this.basePropertiesMap = mapArgs.basePropertiesMap() != null ? mapArgs.basePropertiesMap() : DEFAULT_basePropertiesMap;
        this.extraPropertiesMap = mapArgs.extraPropertiesMap() != null ? mapArgs.extraPropertiesMap() : DEFAULT_extraPropertiesMap;
    }

    public String makeRightMoveUrl(String region) {
        return baseUrl
               + region
               + createExtraProperties(extraPropertiesMap)
               + createProperties(basePropertiesMap);
    }

    private String rightMoveFormatEntry(Map.Entry<String, String> entry) {
        return String.format("&%s=%s", entry.getKey(), entry.getValue());
    }

    private String createProperties(LinkedHashMap<String, String> basePropsMap) {
        return basePropsMap.entrySet().stream()
                .map(this::rightMoveFormatEntry)
                .collect(Collectors.joining(""));
    }

    private String createExtraProperties(LinkedHashMap<String, String> extraPropsMap) {
        return createProperties(extraPropsMap.entrySet().stream()
                .filter(entry -> !entry.getValue().equals(""))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new)));
    }

    // https://www.rightmove.co.uk/property-for-sale/find.html?locationIdentifier=REGION%5E904
    // &propertyTypes=
    // &mustHave=
    // &dontShow=
    // &furnishTypes=
    // &keywords=

    // https://www.rightmove.co.uk/property-for-sale/find.html?locationIdentifier=REGION%5E904
    //      &maxPrice=220000
    //      &minPrice=80000

    //      &propertyTypes=
    //      &mustHave=
    //      &dontShow=
    //      &furnishTypes=
    //      &keywords=

    // https://www.rightmove.co.uk/property-for-sale/find.html?locationIdentifier=REGION%5E904
    // &maxPrice=220000
    // &minPrice=80000

    // &propertyTypes=detached%2Csemi-detached%2Cterraced
    // &mustHave=
    // &dontShow=
    // &furnishTypes=
    // &keywords=

    // https://www.rightmove.co.uk/property-for-sale/find.html?locationIdentifier=REGION%5E904
    // &maxBedrooms=5
    // &minBedrooms=3
    // &maxPrice=220000
    // &minPrice=80000

    // &propertyTypes=detached%2Csemi-detached%2Cterraced
    // &mustHave=garden%2Cparking
    // &dontShow=
    // &furnishTypes=
    // &keywords=
    // &maxDaysSinceAdded=1

}
