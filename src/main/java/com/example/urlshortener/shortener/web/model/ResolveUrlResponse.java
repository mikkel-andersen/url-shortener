package com.example.urlshortener.shortener.web.model;

import com.example.urlshortener.shortener.domain.UrlMapping;

public record ResolveUrlResponse(String originalUrl, String shortCode) {
  public static ResolveUrlResponse from(final UrlMapping mapping) {
    return new ResolveUrlResponse(mapping.originalUrl(), mapping.shortCode());
  }
}
