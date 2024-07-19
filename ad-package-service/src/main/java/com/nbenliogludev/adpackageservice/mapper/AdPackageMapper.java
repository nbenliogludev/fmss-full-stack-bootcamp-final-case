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

//    @Mapping(source = "userId", target = "user_id")
//    @Mapping(source = "numberOfAds", target = "number_of_ads")
//    @Mapping(source = "validityPeriod", target = "validity_period")
//    @Mapping(source = "expirationDate", target = "expiration_date")
//    @Mapping(source = "status", target = "status")
    AdPackage mapAdPackageCreateRequestToAdPackage(AdPackageCreateRequest request);

    AdPackageResponse mapToAdPackageResponse(AdPackage adPackage);
}
