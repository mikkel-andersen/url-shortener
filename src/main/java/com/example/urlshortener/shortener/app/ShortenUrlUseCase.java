package com.example.urlshortener.shortener.app;

import com.example.urlshortener.shortener.app.port.ShortenUrlPort;
import com.example.urlshortener.shortener.app.port.UrlRepositoryPort;
import com.example.urlshortener.shortener.domain.UrlMapping;
import java.time.LocalDateTime;
import java.util.UUID;

public class ShortenUrlUseCase implements ShortenUrlPort {

  private final UrlRepositoryPort repository;

  public ShortenUrlUseCase(final UrlRepositoryPort repository) {
    this.repository = repository;
  }

  @Override
  public UrlMapping shorten(String originalUrl) {
    final var shortCode = UUID.randomUUID().toString().substring(0, 6);
    final var mapping = new UrlMapping(shortCode, originalUrl, LocalDateTime.now());
    return repository.save(mapping);
  }
}
