package com.textanalyzer.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TextAnalyzerServiceTest {

    private TextAnalyzerService service;

    @BeforeEach
    void setUp() {
        service = new TextAnalyzerService();
        List<String> vowelsList = new ArrayList<>(List.of("a","e","i","o","u","á","à","â","ä","ã","å","ā","é","è","ê","ë","ē","ė","ę", "í","ì","î","ï","ī","į",
                "ó","ò","ô","ö","õ","ø","ō","ú","ù","û","ü","ū"));
        ReflectionTestUtils.setField(service,
                "vowelsList", vowelsList);
    }

    @Test
    void testAnalyzeTextWithModeVowels() {
        Map<String, Integer> result = service.analyzeText("peuvent être trouvées ici ou là,", "vowels").getLetterCounts();
        assertEquals(7, result.size());
        assertEquals(1, result.get("À"));
        assertEquals(4, result.get("E"));
        assertEquals(1, result.get("É"));
        assertEquals(1, result.get("Ê"));
        assertEquals(2, result.get("I"));
        assertEquals(2, result.get("O"));
        assertEquals(3, result.get("U"));
    }

    @Test
    void testAnalyzeTextWithModeConsonant() {
        Map<String, Integer> result = service.analyzeText("peuvent être trouvées ici ou là,", "consonants").getLetterCounts();
        assertEquals(8, result.size());
        assertEquals(1, result.get("C"));
        assertEquals(1, result.get("L"));
        assertEquals(1, result.get("N"));
        assertEquals(1, result.get("P"));
        assertEquals(2, result.get("R"));
        assertEquals(1, result.get("S"));
        assertEquals(3, result.get("T"));
        assertEquals(2, result.get("V"));
    }
}
