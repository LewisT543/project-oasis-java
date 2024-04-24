package com.oasis.webscrapingservice.lib.response.parseFns;

import com.oasis.domain.property.Property;
import com.oasis.webscrapingservice.lib.response.CustomFileWriter;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

//PublicTransportDetails publicTransport =
//Tenure tenure =
//Rooms rooms =
//Integer size =
//Boolean hasGarden =

public class DataParser {
    public static DataParseFn<Integer> rightMoveSearchResultCountFn = doc ->
            Integer.parseInt(doc.select(".searchHeader-resultCount").text().replace(",", ""));

    public static DataParseFn<List<Property>> rightMoveSearchCleanFn = doc -> {
        Elements select = doc.select("div[id^=property-]");
        List<Property> parsed = select.stream()
                .filter(DataParser::isResidential)
                .map(DataParser::parseProperty)
                .toList();
        CustomFileWriter.writeToHTML(select, "data/output.html");
        CustomFileWriter.writeToText(parsed, "data/properties.txt");

        return parsed;
    };

    private static Property parseProperty(Element prop) {
        long siteId = Long.parseLong(prop.attr("id").split("-")[1]);
        String location = prop.select("address").text();
        int price = Integer.parseInt(prop.select(".propertyCard-priceValue").text().replace("£", "").replace(",", ""));
        Date addedOn = parseDateOrNull(prop.select(".propertyCard-contactsAddedOrReduced").text());
        String[] bedsAndType = getPropDetails(prop.select(".propertyCard-title").text());
        String propType = bedsAndType[1];
        int bedrooms = Integer.parseInt(bedsAndType[0]);

        return new Property(siteId, location, price, null, addedOn, propType, null, bedrooms, null, null);
    }

    private static boolean isResidential(Element prop) {
        Element link = prop.select("a.propertyCard-link").first();
        if (link == null) return false;
        return !link.attr("href").contains("COM_BUY");
    }

    private static Date parseDateOrNull (String str) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            if (str.contains("today")) return new Date();
            return sdf.parse(str.split("( on )")[1]);
        } catch (ParseException e) {
            return null;
        }
    }

    private static String[] getPropDetails (String str) {
        if (str.contains("Plot for sale")) return new String[]{"Plot for sale", "0"};
        return str.replace(" for sale", "").split("( bedroom )");
    }
}
