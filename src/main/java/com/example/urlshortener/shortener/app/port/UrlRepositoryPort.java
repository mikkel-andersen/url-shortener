package com.example.urlshortener.shortener.app.port;

import com.example.urlshortener.shortener.domain.UrlMapping;

import java.util.Optional;

public interface UrlRepositoryPort {
  /**
   * Saves a {@link UrlMapping} in the database
   *
   * @param mapping
   * @return
   */
  UrlMapping save(UrlMapping mapping);

  /**
   * Finds a {@link UrlMapping} using a short code if no {@link UrlMapping} is found an error is
   * thrown
   *
   * @param shortCode
   * @return
   */
  Optional<UrlMapping> findByShortCode(String shortCode);
}
