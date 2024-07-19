package com.nbenliogludev.adpackageservice.controller;

import com.nbenliogludev.adpackageservice.dto.request.AdPackageCreateRequest;
import com.nbenliogludev.adpackageservice.dto.response.AdPackageResponse;
import com.nbenliogludev.adpackageservice.dto.response.RestResponse;
import com.nbenliogludev.adpackageservice.service.AdPackageService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author nbenliogludev
 */
@RestController
@RequestMapping("/api/v1/adPackages")
@RequiredArgsConstructor
@Tag(name = "Ad Packages Controller", description = "Provides operations for managing ad ad packages")
public class AdPackageController {

    private final AdPackageService adPackageService;

    @Operation(summary = "Create Ad Package", description = "Creates a new ad package")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Ad package created successfully", content = @Content(mediaType = "application/json", schema = @Schema(implementation = AdPackageResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid request body")
    })
    @PostMapping
    public ResponseEntity<RestResponse<AdPackageResponse>> createAdPackage(@RequestBody @Valid AdPackageCreateRequest request) {

        AdPackageResponse createdAd = adPackageService.createAdPackage(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(RestResponse.of(createdAd));
    }

}
