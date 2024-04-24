package com.oasis.webscrapingservice.lib.response.parseFns;

import org.jsoup.nodes.Document;

import java.util.List;

@FunctionalInterface
public interface DataParseFn<T> {
    T apply(Document doc);
}
