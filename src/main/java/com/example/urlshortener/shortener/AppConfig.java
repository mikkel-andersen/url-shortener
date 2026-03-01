package com.example.urlshortener.shortener;

import com.example.urlshortener.resolver.app.ResolveUrlUseCase;
import com.example.urlshortener.shortener.app.ShortenUrlUseCase;
import com.example.urlshortener.shortener.app.port.UrlRepositoryPort;
import com.example.urlshortener.shortener.infra.db.InMemoryUrlRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

  @Bean
  public UrlRepositoryPort urlRepository() {
    return new InMemoryUrlRepository();
  }

  @Bean
  public ResolveUrlUseCase resolveUrlUseCase(final UrlRepositoryPort repository) {
    return new ResolveUrlUseCase(repository);
  }

  @Bean
  public ShortenUrlUseCase shortenUrlUseCase(final UrlRepositoryPort repository) {
    return new ShortenUrlUseCase(repository);
  }
}
