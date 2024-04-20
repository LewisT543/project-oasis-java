package com.oasis.webscrapingservice.lib;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Webscraper<T> {
    private final String baseUrl;
    public List<T> properties = new ArrayList<>();

    public Webscraper(String baseUrl) {
        this.baseUrl = baseUrl;
    }

//    public List<T> getAll() {
//
//    }

    public List<T> getPageOf(String url) {
        try {
            // Fetch content
            Document doc = Jsoup.connect(url).get();

            // Extract elements

            // Clean data?

            //
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return new ArrayList<>();
    }

}
