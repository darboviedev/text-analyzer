package com.textanalyzer.dto;

import java.util.Map;

public class AnalysisResponse {

    private Map<String, Integer> letterCounts;

    public AnalysisResponse(Map<String, Integer> letterCounts) {
        this.letterCounts = letterCounts;
    }

    public Map<String, Integer> getLetterCounts() {
        return letterCounts;
    }

    public void setLetterCounts(Map<String, Integer> letterCounts) {
        this.letterCounts = letterCounts;
    }
}
