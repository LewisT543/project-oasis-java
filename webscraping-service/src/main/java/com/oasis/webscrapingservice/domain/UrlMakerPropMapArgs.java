package com.oasis.webscrapingservice.domain;

import java.util.LinkedHashMap;

public record UrlMakerPropMapArgs(LinkedHashMap<String, String> basePropertiesMap,
                                  LinkedHashMap<String, String> extraPropertiesMap) {
}
