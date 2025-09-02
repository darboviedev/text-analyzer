# Text Analyzer – Backend

## Overview

This repository contains the **Java Spring Boot** backend for the Text Analyzer application. It provides a RESTful API to analyze text input (vowel count and consonant count).\
\
You can use this backend
* **standalone** (e.g. via Postman) or
* **together with the Angular frontend**: [Text Analyzer Frontend](https://github.com/darboviedev/text-analyzer-frontend)

### How to run
* mvn clean install
* mvn spring-boot:run

### Request Endpoint
* POST `http://localhost:8080/api/v1/analysis`
  
### Requestfields & Postman Request
* **Requestfields:**
  * analysisText: "Your Text"
  * analysisMode: "vowels" or "consonants"
    
* **Request Body (JSON):**
```json
{
    "analysisText": "Your text",
    "analysisMode": "vowels"
}
