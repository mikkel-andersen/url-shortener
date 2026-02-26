package com.example.urlshortener.shortener.app.port;

import com.example.urlshortener.shortener.domain.UrlMapping;

public interface ShortenUrlPort {
  /**
   * Shortens a given URL and returns {@link UrlMapping}
   *
   * @param originalUrl
   * @return {@link UrlMapping}
   */
  UrlMapping shorten(String originalUrl);
}
