package com.oasis.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class MathsUtils {
    public static double toTwoDP(Number input) {
        BigDecimal bd = new BigDecimal(input.toString());
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}
