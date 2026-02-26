package com.example.urlshortener.shortener.web;

import com.example.urlshortener.shortener.web.doc.ShortenUrlDoc;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.urlshortener.shortener.app.port.ShortenUrlPort;
import com.example.urlshortener.shortener.web.model.ShortenUrlRequest;
import com.example.urlshortener.shortener.web.model.ShortenUrlResponse;

@RestController
@RequestMapping("/urls")
public class UrlController {

  private final ShortenUrlPort shortenUrlPort;

  public UrlController(ShortenUrlPort shortenUrlPort) {
    this.shortenUrlPort = shortenUrlPort;
  }

  @ShortenUrlDoc
  @PostMapping("/shorten")
  public ShortenUrlResponse shorten(@RequestBody ShortenUrlRequest request) {
    final var shortenedUrl = shortenUrlPort.shorten(request.url());
    return ShortenUrlResponse.from(shortenedUrl);
  }
}
