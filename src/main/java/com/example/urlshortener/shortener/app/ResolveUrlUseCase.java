package com.example.urlshortener.shortener.app;

import com.example.urlshortener.shortener.app.port.ResolveUrlPort;
import com.example.urlshortener.shortener.app.port.UrlRepositoryPort;
import com.example.urlshortener.shortener.domain.UrlMapping;

public class ResolveUrlUseCase implements ResolveUrlPort {

  private final UrlRepositoryPort repository;

  public ResolveUrlUseCase(UrlRepositoryPort repository) {
    this.repository = repository;
  }

  @Override
  public UrlMapping resolve(String shortCode) {
    return repository
        .findByShortCode(shortCode)
        .orElseThrow(() -> new IllegalArgumentException("Short code not found"));
  }
}
