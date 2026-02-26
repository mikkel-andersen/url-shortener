package com.example.urlshortener.shortener.web.model;

import com.example.urlshortener.shortener.domain.UrlMapping;

public record ShortenUrlResponse(String originalUrl, String shortCode) {
  public static ShortenUrlResponse from(final UrlMapping urlMapping) {
    return new ShortenUrlResponse(urlMapping.originalUrl(), urlMapping.shortCode());
  }
}
