package com.oasis.webscrapingservice.lib.request.updateFns;

@FunctionalInterface
public interface UrlUpdateFn {
    String apply(String string);
}
