package com.nbenliogludev.adpackageservice.service.Impl;

import com.nbenliogludev.adpackageservice.mapper.AdPackageMapper;
import com.nbenliogludev.adpackageservice.service.AdPackageService;
import com.nbenliogludev.adpackageservice.dto.request.AdPackageCreateRequest;
import com.nbenliogludev.adpackageservice.dto.response.AdPackageResponse;
import com.nbenliogludev.adpackageservice.entity.AdPackage;
import com.nbenliogludev.adpackageservice.repository.AdPackageRepository;
import com.nbenliogludev.adpackageservice.util.AppLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author nbenliogludev
 */
@Service
@RequiredArgsConstructor
public class AdPackageServiceImpl implements AdPackageService {

    private final AdPackageRepository adPackageRepository;
    private final AdPackageMapper adPackageMapper;
    private final AppLogger appLogger;

    @Override
    public AdPackageResponse createAdPackage(AdPackageCreateRequest request) {
        appLogger.logInfo("AdPackageService", "Creating ad package with request details: " + request.toString());
        AdPackage adPackage = adPackageMapper.mapAdPackageCreateRequestToAdPackage(request);
        adPackage = adPackageRepository.save(adPackage);
        appLogger.logInfo("AdPackageService", "Ad package created successfully with ID: " + adPackage.getId());

        return adPackageMapper.mapToAdPackageResponse(adPackage);
    }

    @Override
    public List<AdPackageResponse> getAllAdPackages() {
        appLogger.logInfo("AdPackageService", "Fetching all ad packages");
        List<AdPackage> adPackages = adPackageRepository.findAll();

        return adPackages.stream()
                .map(adPackageMapper::mapToAdPackageResponse)
                .toList();
    }

    @Override
    public AdPackageResponse getAdPackageById(Long id) {
        appLogger.logInfo("AdPackageService", "Fetching ad package by ID: " + id);
        Optional<AdPackage> adPackageOptional = adPackageRepository.findById(id);
        return adPackageMapper.mapToAdPackageResponse(adPackageOptional.get());
    }

    @Override
    public AdPackageResponse updateAdPackage(Long id, AdPackageCreateRequest request) {
        appLogger.logInfo("AdPackageService", "Updating ad package with ID: " + id);
        Optional<AdPackage> adOptional = adPackageRepository.findById(id);

        AdPackage adPackage = adOptional.get();
        adPackage.setNumberOfAds(request.numberOfAds());
        adPackage.setValidityPeriod(request.validityPeriod());
        adPackage.setExpirationDate(request.expirationDate());
        adPackage.setStatus(request.status());
        adPackageRepository.save(adPackage);
        appLogger.logInfo("AdPackageService", "Ad package updated successfully for ID: " + adPackage.getId());

        return adPackageMapper.mapToAdPackageResponse(adPackage);
    }

    @Override
    public void deleteAdPackage(Long id) {
        appLogger.logInfo("AdPackageService", "Deleting ad package with ID: " + id);
        adPackageRepository.deleteById(id);
        appLogger.logInfo("AdPackageService", "Ad package deleted successfully with ID: " + id);
    }
}
