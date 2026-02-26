package com.example.urlshortener.shortener;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.example.urlshortener.shortener.app.ShortenUrlUseCase;
import com.example.urlshortener.shortener.app.port.UrlRepositoryPort;
import com.example.urlshortener.shortener.infra.db.InMemoryUrlRepository;

@Configuration
public class AppConfig {

    @Bean
    public UrlRepositoryPort urlRepository() {
        return new InMemoryUrlRepository();
    }

    @Bean
    public ShortenUrlUseCase shortenUrlUseCase(UrlRepositoryPort repository) {
        return new ShortenUrlUseCase(repository);
    }

}
