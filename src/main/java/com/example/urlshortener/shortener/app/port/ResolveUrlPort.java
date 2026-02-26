package com.example.urlshortener.shortener.app.port;

import com.example.urlshortener.shortener.domain.UrlMapping;

public interface ResolveUrlPort {
  UrlMapping resolve(String shortCode);
}
