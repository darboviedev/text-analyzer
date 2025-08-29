package com.textanalyzer.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TextAnalyzerServiceTest {

    private TextAnalyzerService service;

    @BeforeEach
    void setUp() {
        service = new TextAnalyzerService();
        ReflectionTestUtils.setField(service,
                "configuredVowels", ",à,á,â,ã,ä,å,æ,e,è,é,ê,ë,i,ì,í,î,ï,o,ò,ó,ô,õ,ö,ø,œ,u,ù,ú,û,ü,ű");
        service.initVowels();
    }

    @Test
    void testAnalyzeTextWithModeVowels() {
        Map<String, Integer> result = service.analyzeText("peuvent être trouvées ici ou là,", "vowels");
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
        Map<String, Integer> result = service.analyzeText("peuvent être trouvées ici ou là,", "consonants");
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

    @Test
    void testInitVowelsThrowsWhenNull() {
        service = new TextAnalyzerService();
        ReflectionTestUtils.setField(service, "configuredVowels", null);
        Exception exception = assertThrows(IllegalStateException.class, service::initVowels);
        assertEquals("textanalyzer.properties file is missing", exception.getMessage());
    }

    @Test
    void testInitVowelsThrowsWhenEmpty() {
        service = new TextAnalyzerService();
        ReflectionTestUtils.setField(service, "configuredVowels", "");
        Exception exception = assertThrows(IllegalStateException.class, service::initVowels);
        assertEquals("textanalyzer.properties is empty", exception.getMessage());
    }
}
