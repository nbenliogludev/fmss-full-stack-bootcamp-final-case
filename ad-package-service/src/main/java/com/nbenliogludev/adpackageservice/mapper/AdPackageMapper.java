package com.nbenliogludev.adpackageservice.mapper;

import com.nbenliogludev.adpackageservice.dto.request.AdPackageCreateRequest;
import com.nbenliogludev.adpackageservice.dto.response.AdPackageResponse;
import com.nbenliogludev.adpackageservice.entity.AdPackage;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

/**=
 *
 * @author nbenliogludev
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface AdPackageMapper {

    @Mapping(source = "user_id", target = "user_id")
    @Mapping(source = "number_of_ads", target = "number_of_ads")
    @Mapping(source = "validity_period", target = "validity_period")
    @Mapping(source = "expiration_date", target = "expiration_date")
    @Mapping(source = "status", target = "status")
    AdPackage mapAdPackageCreateRequestToAdPackage(AdPackageCreateRequest request);

    AdPackageResponse mapToAdPackageResponse(AdPackage adPackage);
}
