package com.oasis.domain.suitability;

import java.util.List;

public class LocationLists {
    private List<String> whitelist;
    private List<String> blacklist;

    public LocationLists(List<String> whitelist, List<String> blacklist) {
        this.whitelist = whitelist;
        this.blacklist = blacklist;
    }
}
