package com.nbenliogludev.adpackageservice.service;

import com.nbenliogludev.adpackageservice.dto.request.AdPackageCreateRequest;
import com.nbenliogludev.adpackageservice.dto.response.AdPackageResponse;

public interface AdPackageService {
    AdPackageResponse createAdPackage(AdPackageCreateRequest request);
}
