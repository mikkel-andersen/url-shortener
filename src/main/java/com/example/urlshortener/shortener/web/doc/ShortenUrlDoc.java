package com.example.urlshortener.shortener.web.doc;

import com.example.urlshortener.shortener.web.model.ShortenUrlResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import java.lang.annotation.*;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Operation(
    summary = "Shorten a URL",
    description = "Generates a short code for a given URL",
    responses = {
      @ApiResponse(
          responseCode = "200",
          description = "Successfully shortened URL",
          content = @Content(schema = @Schema(implementation = ShortenUrlResponse.class))),
      @ApiResponse(responseCode = "400", description = "Invalid URL provided")
    })
public @interface ShortenUrlDoc {}
