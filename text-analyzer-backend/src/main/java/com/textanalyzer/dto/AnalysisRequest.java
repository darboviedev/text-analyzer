package com.textanalyzer.dto;

import jakarta.validation.constraints.NotEmpty;

public class AnalysisRequest {

    @NotEmpty(message = "Analysis text may not be null or empty")
    private String analysisText;

    @NotEmpty(message = "Analysis mode may not be null or empty")
    private String analysisMode;

    public String getAnalysisText() {
        return analysisText;
    }

    public void setAnalysisText(String analysisText) {
        this.analysisText = analysisText;
    }

    public String getAnalysisMode() {
        return analysisMode;
    }

    public void setAnalysisMode(String analysisMode) {
        this.analysisMode = analysisMode;
    }
}
