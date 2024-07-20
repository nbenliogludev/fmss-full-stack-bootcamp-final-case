package com.nbenliogludev.adpackageservice.mapper;

import com.nbenliogludev.adpackageservice.dto.request.AdPackageCreateRequest;
import com.nbenliogludev.adpackageservice.dto.response.AdPackageResponse;
import com.nbenliogludev.adpackageservice.entity.AdPackage;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

/**
 *
 * @author nbenliogludev
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface AdPackageMapper {

    @Mapping(source = "userId", target = "userId")
    @Mapping(source = "numberOfAds", target = "numberOfAds")
    @Mapping(source = "validityPeriod", target = "validityPeriod")
    @Mapping(source = "expirationDate", target = "expirationDate")
    @Mapping(source = "status", target = "status")
    AdPackage mapAdPackageCreateRequestToAdPackage(AdPackageCreateRequest request);

    AdPackageResponse mapToAdPackageResponse(AdPackage adPackage);
}
