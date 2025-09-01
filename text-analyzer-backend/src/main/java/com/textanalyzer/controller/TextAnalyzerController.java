package com.textanalyzer.controller;

import com.textanalyzer.dto.AnalysisRequest;
import com.textanalyzer.dto.AnalysisResult;
import com.textanalyzer.service.TextAnalyzerService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class TextAnalyzerController {

    private final TextAnalyzerService analyzerService;

    public TextAnalyzerController(TextAnalyzerService analyzerService) {
        this.analyzerService = analyzerService;
    }

    // TODO in @Get umwandeln
    @PostMapping("/analysis")
    public ResponseEntity<AnalysisResult> analyze(@Valid @RequestBody AnalysisRequest request) {
        return ResponseEntity.ok(analyzerService.analyzeText(request.getAnalysisText(), request.getAnalysisMode()));
    }


}
