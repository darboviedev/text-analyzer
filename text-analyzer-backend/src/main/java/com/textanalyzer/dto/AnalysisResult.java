package com.textanalyzer.dto;

import java.util.Map;

public class AnalysisResult {

    private Map<String, Integer> letterCounts;

    private String analysisText;

    private String analysisMode;

    public AnalysisResult(Map<String, Integer> letterCounts, String analysisText, String analysisMode) {
        this.letterCounts = letterCounts;
        this.analysisText = analysisText;
        this.analysisMode = analysisMode;
    }

    public Map<String, Integer> getLetterCounts() {
        return letterCounts;
    }

    public void setLetterCounts(Map<String, Integer> letterCounts) {
        this.letterCounts = letterCounts;
    }

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
