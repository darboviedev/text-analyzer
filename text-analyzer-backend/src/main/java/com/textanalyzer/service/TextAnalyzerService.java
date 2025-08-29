package com.textanalyzer.service;

import com.textanalyzer.util.TextAnalyzerConstants;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.text.Collator;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class TextAnalyzerService {

    @Value("${textanalyzer.vowels}")
    String configuredVowels;

    Set<Character> configuredVowelSet;

    @PostConstruct
    public void initVowels(){
        // TODO braucht man eigenltich nicht - fehlende .properties führt beim Start zum Absturz
        if (configuredVowels == null){
            throw new IllegalStateException("textanalyzer.properties file is missing");
        }
        if (configuredVowels.isEmpty()) {
            throw new IllegalStateException("textanalyzer.properties is empty");
        }

        configuredVowelSet = Arrays.stream(configuredVowels.split(","))
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .map(s -> s.toLowerCase().charAt(0))
                .collect(Collectors.toSet());
    }

    public Map<String, Integer> analyzeText(String text, String mode) {
        if (text == null || text.isEmpty()) {
            return Collections.emptyMap();
        }

        if (TextAnalyzerConstants.MODE_VOWELS.equalsIgnoreCase(mode)) {
            return countCharacters(text, c -> configuredVowelSet.contains(c));
        } else if (TextAnalyzerConstants.MODE_CONSONANTS.equalsIgnoreCase(mode)) {
            return countCharacters(text, c -> Character.isLetter(c) && !configuredVowelSet.contains(c));
        }
        // TODO unbekannter Modus
        return Collections.emptyMap();
    }

    private Map<String, Integer> countCharacters(String text, Predicate<Character> shouldCount) {
        Map<String, Integer> result = new TreeMap<>(Collator.getInstance(Locale.GERMAN));

        for (char c : text.toLowerCase().toCharArray()) {
            if (shouldCount.test(c)) {
                String character = String.valueOf(c).toUpperCase();
                result.put(character, result.getOrDefault(character, 0) + 1);
            }
        }
        return result;
    }
}
