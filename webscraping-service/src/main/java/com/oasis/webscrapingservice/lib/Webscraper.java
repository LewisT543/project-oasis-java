package com.oasis.webscrapingservice.lib;

import com.oasis.webscrapingservice.lib.response.parseFns.DataParseFn;
import com.oasis.webscrapingservice.lib.request.updateFns.UrlUpdateFn;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Webscraper<T> {
    public List<List<T>> getAllPagesOf(String url, DataParseFn<List<T>> parseFn, UrlUpdateFn urlFn, DataParseFn<Integer> resultCountFn, int resPerPage) {
        Document doc = docFromSoup(url);
        int resultCount = resultCountFn.apply(doc);
        List<String> urls = IntStream.range(0, resultCount / resPerPage).mapToObj(s -> urlFn.apply(url)).toList();
        List<List<T>> pages = urls.stream().map(indexedUrl -> getPageOf(indexedUrl, parseFn)).toList();
        return pages;
    }

    public List<T> getPageOf(String url, DataParseFn<List<T>> parseFn) {
        Document doc = docFromSoup(url);
        return parseFn.apply(doc);
    }

    public List<T> fromOutputHtml(String filePath, DataParseFn<List<T>> parseFn) {
        Document doc = docFromHtml(filePath);
        return parseFn.apply(doc);
    }

    private Document docFromSoup(String url) {
        try {
            return Jsoup.connect(url)
                    .userAgent(getUserAgent())
                    .get();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Document docFromHtml(String filePath) {
        try {
            StringBuilder htmlContent = new StringBuilder();
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                htmlContent.append(scanner.nextLine());
                htmlContent.append("\n");
            }
            scanner.close();
            return Jsoup.parse(String.valueOf(htmlContent));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private String getUserAgent() {
        // TODO: Rotate agents using randInt
        return "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/124.0.0.0 Safari/537.36";
    }

}
