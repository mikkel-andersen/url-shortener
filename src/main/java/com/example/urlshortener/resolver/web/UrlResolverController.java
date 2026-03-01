package com.example.urlshortener.resolver.web;

import com.example.urlshortener.resolver.app.port.UrlResolverPort;
import com.example.urlshortener.resolver.web.doc.ResolveUrlDoc;
import java.net.URI;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/urls")
public class UrlResolverController {

  private final UrlResolverPort urlResolverPort;

  public UrlResolverController(final UrlResolverPort urlResolverPort) {
    this.urlResolverPort = urlResolverPort;
  }

  @ResolveUrlDoc
  @GetMapping("/{shortCode}")
  public ResponseEntity<Void> resolve(@PathVariable final String shortCode) {
    final var mapping = urlResolverPort.resolve(shortCode);

    return ResponseEntity.status(HttpStatus.FOUND)
        .location(URI.create(mapping.originalUrl()))
        .build();
  }
}
