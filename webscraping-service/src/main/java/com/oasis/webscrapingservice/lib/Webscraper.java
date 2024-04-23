package com.oasis.webscrapingservice.lib;

import com.oasis.webscrapingservice.lib.response.parseFns.DataParseFn;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.List;

public class Webscraper<T> {
    public List<T> getPageOf(String url, DataParseFn<T> parseFn) {
        try {
            Document doc = Jsoup.connect(url)
                    .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/124.0.0.0 Safari/537.36")
                    .get();
            return parseFn.apply(doc);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
