package com.example.urlshortener.resolver.app;

import com.example.urlshortener.resolver.app.port.UrlResolverPort;
import com.example.urlshortener.shortener.app.port.UrlRepositoryPort;
import com.example.urlshortener.shortener.domain.UrlMapping;

public class ResolveUrlUseCase implements UrlResolverPort {

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
