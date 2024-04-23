package com.oasis.webscrapingservice.lib.response.parseFns;

import com.oasis.domain.property.Property;
import org.jsoup.select.Elements;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static com.oasis.webscrapingservice.lib.response.CustomFileWriter.writeToHTML;
import static com.oasis.webscrapingservice.lib.response.CustomFileWriter.writeToText;

public class DataParser {
    public static DataParseFn<Property> rightMoveSearchCleanFn = doc -> {
        Elements select = doc.select("div[id^=property-]");
        List<Property> parsed = select.stream().map(prop -> {
//            PublicTransportDetails publicTransport =
//            Tenure tenure =
//            Rooms rooms =
//            Integer size =
//            Boolean hasGarden =
            long siteId = Long.parseLong(prop.attr("id").split("-")[1]);
            System.out.println(siteId);
            System.out.println(prop);
            String location = prop.select("address").text();
            int price = Integer.parseInt(prop.select(".propertyCard-priceValue").text().replace("£", "").replace(",", ""));
            Date addedOn = parseDateOrNull(prop.select(".propertyCard-contactsAddedOrReduced").text());
            String[] bedsAndType = getPropDetails(prop.select(".propertyCard-title").text());
            String propType = bedsAndType[1];
            int bedrooms = Integer.parseInt(bedsAndType[0]);

            return new Property(siteId, location, price, null, addedOn, propType, null, bedrooms, null, null);
        }).toList();
        writeToHTML(select, "output.html");
        writeToText(parsed, "properties.txt");

        return parsed;
    };


    private static Date parseDateOrNull (String str) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            // Remove commercial properties?
            // "Marketed by XYV"
            if (str.contains("today")) return new Date();
            return sdf.parse(str.split("( on )")[1]);
        } catch (ParseException e) {;
            return null;
        }
    }

    private static String[] getPropDetails (String str) {
        // TODO: Handle the case where commercial property gets in here - or change the parser so it doesn't throw errors until we have written the data
        // "Plot for sale"
        return str.replace(" for sale", "").split("( bedroom )");
    }
}
