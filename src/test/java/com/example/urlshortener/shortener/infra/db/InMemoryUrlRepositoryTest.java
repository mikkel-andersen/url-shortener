package com.example.urlshortener.shortener.infra.db;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.urlshortener.shortener.domain.UrlMapping;
import java.time.LocalDateTime;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InMemoryUrlRepositoryTest {

  private InMemoryUrlRepository repository;

  @BeforeEach
  void setUp() {
    repository = new InMemoryUrlRepository();
  }

  @Test
  void save_url_mapping_stores_url_mapping() {
    // Arrange
    final var now = LocalDateTime.now();
    final var urlMapping = new UrlMapping("someShortCode", "someUrl", now);

    // Act
    final var actual = repository.save(urlMapping);

    // Assert
    assertThat(repository.findByShortCode("someShortCode").get())
        .usingRecursiveAssertion()
        .isEqualTo(actual);
  }

  @Test
  void save_returns_url_mapping() {
    // Arrange
    final var now = LocalDateTime.now();
    final var urlMapping = new UrlMapping("someShortCode", "someUrl", now);

    // Act
    final var actual = repository.save(urlMapping);

    // Assert
    assertThat(actual).usingRecursiveAssertion().isEqualTo(urlMapping);
  }

  @Test
  void find_by_short_code_returns_optional_empty() {
    // Act
    final var actual = repository.findByShortCode("someShortCode");

    // Assert
    assertThat(actual).isEmpty();
  }

  @Test
  void find_by_short_code_returns_optional_of_url_mapping() {
    // Arrange
    final var now = LocalDateTime.now();
    final var urlMapping = new UrlMapping("someShortCode", "someUrl", now);
    repository.save(urlMapping);

    // Act
    final var actual = repository.findByShortCode("someShortCode");

    // Assert
    assertThat(actual).isPresent();
    assertThat(actual.get()).isEqualTo(urlMapping);
  }
}
