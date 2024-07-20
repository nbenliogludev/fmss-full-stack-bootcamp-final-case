package com.nbenliogludev.adpackageservice.dto.request;

import com.nbenliogludev.adpackageservice.enums.AdPackageStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.time.LocalDateTime;

/**
 * @author nbenliogludev
 */
@Builder
public record AdPackageCreateRequest (

        @NotNull(message = "User Id is required.")
        String userId,

        @NotNull(message = "Number of ads is required.")
        int numberOfAds,

        @NotNull(message = "Valid Period is required.")
        int validityPeriod,

        @NotNull(message = "Expiration date is required.")
        LocalDateTime expirationDate,

        @NotNull(message = "Status is required.")
        @Enumerated(EnumType.STRING)
        AdPackageStatus status
) {
}
