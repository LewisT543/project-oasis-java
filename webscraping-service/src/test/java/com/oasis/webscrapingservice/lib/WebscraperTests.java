package com.oasis.webscrapingservice.lib;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class WebscraperTests {

    @Test
    public void getPageOf_ValidUrl_ReturnsExpectedPageContent() throws IOException, IOException {
        // Given
        String url = "https://example.com";
        Document mockDocument = mock(Document.class);
        when(Jsoup.connect(url).get()).thenReturn(mockDocument);

        // When
        Webscraper<String> webscraper = new Webscraper<>(url);
        webscraper.getPageOf(url);

        // Then
        // Verify that Jsoup.connect(url).get() was called
        assertEquals(mockDocument, Jsoup.connect(url).get());
    }
}
