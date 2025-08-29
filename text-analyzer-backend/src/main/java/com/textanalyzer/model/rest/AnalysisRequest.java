package com.textanalyzer.model.rest;

public class AnalysisRequest {

    private String text;
    private String mode;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }
}
