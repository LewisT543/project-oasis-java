package com.oasis.domain.mortgage;

public class CalcResult {
    private double lowResult;
    private double highResult;

    public CalcResult(double lowResult, double highResult) {
        this.lowResult = lowResult;
        this.highResult = highResult;
    }

    public double getLowResult() {
        return lowResult;
    }

    public void setLowResult(double lowResult) {
        this.lowResult = lowResult;
    }

    public double getHighResult() {
        return highResult;
    }

    public void setHighResult(double highResult) {
        this.highResult = highResult;
    }
}
