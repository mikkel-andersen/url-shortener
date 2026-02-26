package com.example.urlshortener.shortener.web;

import com.example.urlshortener.shortener.app.port.ResolveUrlPort;
import com.example.urlshortener.shortener.app.port.ShortenUrlPort;
import com.example.urlshortener.shortener.web.doc.ShortenUrlDoc;
import com.example.urlshortener.shortener.web.model.ResolveUrlResponse;
import com.example.urlshortener.shortener.web.model.ShortenUrlRequest;
import com.example.urlshortener.shortener.web.model.ShortenUrlResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/urls")
public class UrlController {

  private final ShortenUrlPort shortenUrlPort;
  private final ResolveUrlPort resolveUrlPort;

  public UrlController(final ShortenUrlPort shortenUrlPort, final ResolveUrlPort resolveUrlPort) {
    this.shortenUrlPort = shortenUrlPort;
    this.resolveUrlPort = resolveUrlPort;
  }

  @ShortenUrlDoc
  @PostMapping("/shorten")
  public ShortenUrlResponse shorten(@RequestBody final ShortenUrlRequest request) {
    final var shortenedUrl = shortenUrlPort.shorten(request.url());
    return ShortenUrlResponse.from(shortenedUrl);
  }

  @GetMapping("/{shortCode}")
  public ResolveUrlResponse resolve(@PathVariable String shortCode) {
    var mapping = resolveUrlPort.resolve(shortCode);
    return ResolveUrlResponse.from(mapping);
  }
}
