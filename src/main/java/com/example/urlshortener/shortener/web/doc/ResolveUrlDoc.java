package com.example.urlshortener.shortener.web.doc;

import com.example.urlshortener.shortener.web.model.ResolveUrlResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "URL Resolver", description = "API for resolving short codes to original URLs")
@Operation(
    summary = "Resolve a short URL",
    description = "Given a short code, returns the original URL",
    responses = {
      @ApiResponse(
          responseCode = "200",
          description = "Successfully resolved the URL",
          content = @Content(schema = @Schema(implementation = ResolveUrlResponse.class))),
      @ApiResponse(responseCode = "404", description = "Short code not found")
    })
public @interface ResolveUrlDoc {}
