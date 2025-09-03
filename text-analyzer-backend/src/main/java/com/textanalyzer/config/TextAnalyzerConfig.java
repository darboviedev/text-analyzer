package com.textanalyzer.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import java.io.IOException;

/**
 * Loads a list of vowels from a JSON file and maps it to a VowelsList bean.
 * The List is then injected into TextAnalyzerService.
 */
@Configuration
public class TextAnalyzerConfig {

    @Bean
    public VowelsSet loadVowels() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new ClassPathResource("config/vowels.json").getFile(),
                VowelsSet.class);
    }
}
