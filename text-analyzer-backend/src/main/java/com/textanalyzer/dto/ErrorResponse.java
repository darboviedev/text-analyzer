package com.textanalyzer.dto;

import java.time.LocalDateTime;

public class ErrorResponse {
    private final LocalDateTime timestamp;
    private final int httpStatusCode;
    private final String httpStatusText;
    private final String message;
    private final String path;

    public ErrorResponse(int httpStatusCode, String httpStatusText, String message, String path) {
        this.timestamp = LocalDateTime.now();
        this.httpStatusCode = httpStatusCode;
        this.httpStatusText = httpStatusText;
        this.message = message;
        this.path = path;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public int getHttpStatusCode() {
        return httpStatusCode;
    }

    public String getHttpStatusText() {
        return httpStatusText;
    }

    public String getMessage() {
        return message;
    }

    public String getPath() {
        return path;
    }
}
