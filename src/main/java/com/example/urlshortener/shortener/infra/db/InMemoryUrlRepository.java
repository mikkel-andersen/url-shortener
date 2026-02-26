package com.example.urlshortener.shortener.infra.db;

import com.example.urlshortener.shortener.app.port.UrlRepositoryPort;
import com.example.urlshortener.shortener.domain.UrlMapping;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class InMemoryUrlRepository implements UrlRepositoryPort {
  private final Map<String, UrlMapping> storage = new HashMap<>();

  @Override
  public UrlMapping save(UrlMapping mapping) {
    storage.put(mapping.shortCode(), mapping);
    return mapping;
  }

  @Override
  public Optional<UrlMapping> findByShortCode(String shortCode) {
    return Optional.ofNullable(storage.get(shortCode));
  }
}
