package com.oasis.webscrapingservice.lib.request;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class URLArgsParser {
    public static LinkedHashMap<String, String> parseURLArgs(String url) {
        return Arrays.stream(url.split("\\?")).skip(1)
                .flatMap(query -> Arrays.stream(query.split("&")))
                .map(pair -> pair.split("="))
                .map(keyValue -> keyValue.length == 2 ? keyValue : handleInvalidPair(keyValue))
                .collect(LinkedHashMap::new, (map, keyValue) -> map.put(keyValue[0], keyValue[1]), LinkedHashMap::putAll);
    }

    public static String buildURLArgs(String baseUrl, LinkedHashMap<String, String> map) {
        return baseUrl + map.entrySet().stream()
                .map(entry -> entry.getKey() + "=" + entry.getValue())
                .reduce((s1, s2) -> s1 + "&" + s2)
                .orElse("");
    }

    public static LinkedHashMap<String, String> updateURLArgs(LinkedHashMap<String, String> argsMap, LinkedHashMap<String, String> newArgsMap) {
        return argsMap.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> newArgsMap.containsKey(entry.getKey())
                                ? newArgsMap.get(entry.getKey())
                                : entry.getValue(),
                        (existingValue, newValue) -> existingValue,
                        LinkedHashMap::new
                ));
    }

    private static String[] handleInvalidPair(String[] keyValue) {
        return new String[]{ keyValue[0], String.join("=", Arrays.copyOfRange(keyValue, 1, keyValue.length)) };
    }
}
