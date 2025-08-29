package com.textanalyzer.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:/config/textanalyzer.properties")
public class TextAnalyzerConfig {
}
