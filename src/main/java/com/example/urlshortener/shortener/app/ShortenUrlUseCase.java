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
    final var normalizedUrl = normalize(originalUrl);
    final var shortCode = UUID.randomUUID().toString().substring(0, 6);
    final var mapping = new UrlMapping(shortCode, normalizedUrl, LocalDateTime.now());
    return repository.save(mapping);
  }

  private String normalize(final String url) {
    if (!url.startsWith("http://") && !url.startsWith("https://")) {
      return "https://" + url;
    }
    return url;
  }
}
