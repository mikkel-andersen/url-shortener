package com.example.urlshortener.resolver.app.port;

import com.example.urlshortener.shortener.domain.UrlMapping;

public interface UrlResolverPort {
  UrlMapping resolve(String shortCode);
}
