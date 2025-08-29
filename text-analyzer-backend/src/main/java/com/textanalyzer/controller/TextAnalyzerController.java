package com.textanalyzer.controller;

import com.textanalyzer.model.rest.AnalysisRequest;
import com.textanalyzer.model.rest.AnalysisResponse;
import com.textanalyzer.service.TextAnalyzerService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class TextAnalyzerController {

    private final TextAnalyzerService analyzerService;

    public TextAnalyzerController(TextAnalyzerService analyzerService) {
        this.analyzerService = analyzerService;
    }
    @PostMapping("/analyze")
    public AnalysisResponse analyze(@RequestBody AnalysisRequest request) {
        Map<String, Integer> counts = analyzerService.analyzeText(request.getText(), request.getMode());
        return new AnalysisResponse(counts);
    }
}
