package com.textanalyzer.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class TextAnalyzerService {


    public Map<String,Integer> analyzeText(String text, String mode) {

        Map<String,Integer> analysisResult = new HashMap<>();
        analysisResult.put(text + " processed", 1);
        analysisResult.put(mode + " processed", 2);

        return analysisResult;
    }
}
