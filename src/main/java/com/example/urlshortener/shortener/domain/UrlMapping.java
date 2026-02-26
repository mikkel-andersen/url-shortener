package com.example.urlshortener.shortener.domain;

import java.time.LocalDateTime;

public record UrlMapping(String shortCode, String originalUrl, LocalDateTime createdAt) {}
