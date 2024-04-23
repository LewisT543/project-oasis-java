package com.oasis.webscrapingservice.lib.response;

import com.oasis.domain.property.Property;
import org.jsoup.select.Elements;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class CustomFileWriter {
    public static void writeToHTML(Elements raw, String filePath) {
        String htmlBuilder = "<!DOCTYPE html><html><head><title>Data Output</title></head><body>" +
                             raw.toString() +
                             "</body></html>";
        writeFile(htmlBuilder, filePath);
    }

    public static void writeToText(List<Property> propsList, String filePath) {
        String textBuilder = propsList.stream().map(Object::toString).collect(Collectors.joining("\n"));
        writeFile(textBuilder, filePath);
    }

    private static void writeFile (String builder, String filePath) {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(builder);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
