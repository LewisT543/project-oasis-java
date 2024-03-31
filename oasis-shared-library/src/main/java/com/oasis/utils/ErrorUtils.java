package com.oasis.utils;

public class ErrorUtils {
    public static String notFoundError(String object, String attributeName, String value) {
        return object + " with " + attributeName + ": " + value + " not found.";
    }
}
