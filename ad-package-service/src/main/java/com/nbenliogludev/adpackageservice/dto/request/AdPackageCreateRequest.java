package com.nbenliogludev.adpackageservice.dto.request;

import com.nbenliogludev.adpackageservice.enums.AdPackageStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.time.LocalDateTime;

/**
 * @author nbenliogludev
 */
@Builder
public record AdPackageCreateRequest (

        @NotBlank(message = "User Id is required.")
        String userId,

        @NotBlank(message = "Number of ads is required.")
        int numberOfAds,

        @NotNull(message = "Validy Period is required.")
        int validityPeriod,

        @NotNull(message = "Expiration date is required.")
        LocalDateTime expirationDate,

        @NotNull(message = "Status is required.")
        @Enumerated(EnumType.STRING)
        AdPackageStatus status
) {
}
