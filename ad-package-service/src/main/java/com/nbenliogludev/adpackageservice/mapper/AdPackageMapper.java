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

    @Mapping(source = "title", target = "title")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "status", target = "status")
    @Mapping(source = "amount", target = "amount")
    AdPackage mapAdPackageCreateRequestToAdPackage(AdPackageCreateRequest request);

    AdPackageResponse mapToAdPackageResponse(AdPackage adPackage);
}
