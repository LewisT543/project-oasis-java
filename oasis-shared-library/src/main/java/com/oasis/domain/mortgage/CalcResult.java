package com.oasis.domain.mortgage;

public class CalcResult {
    private SingleResult lowResult;
    private SingleResult highResult;

    public CalcResult(SingleResult lowResult, SingleResult highResult) {
        this.lowResult = lowResult;
        this.highResult = highResult;
    }
}
