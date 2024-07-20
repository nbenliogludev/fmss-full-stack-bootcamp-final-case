package com.nbenliogludev.adpackageservice.service.Impl;

import com.nbenliogludev.adpackageservice.mapper.AdPackageMapper;
import com.nbenliogludev.adpackageservice.service.AdPackageService;
import com.nbenliogludev.adpackageservice.dto.request.AdPackageCreateRequest;
import com.nbenliogludev.adpackageservice.dto.response.AdPackageResponse;
import com.nbenliogludev.adpackageservice.entity.AdPackage;
import com.nbenliogludev.adpackageservice.repository.AdPackageRepository;
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

    @Override
    public AdPackageResponse createAdPackage(AdPackageCreateRequest request) {

        AdPackage adPackage = adPackageMapper.mapAdPackageCreateRequestToAdPackage(request);
        adPackage = adPackageRepository.save(adPackage);

        return adPackageMapper.mapToAdPackageResponse(adPackage);
    }

    @Override
    public List<AdPackageResponse> getAllAdPackages() {

        List<AdPackage> adPackages = adPackageRepository.findAll();

        return adPackages.stream()
                .map(adPackageMapper::mapToAdPackageResponse)
                .toList();
    }

    @Override
    public AdPackageResponse getAdPackageById(Long id) {

        Optional<AdPackage> adPackageOptional = adPackageRepository.findById(id);

        return adPackageMapper.mapToAdPackageResponse(adPackageOptional.get());
    }

    @Override
    public AdPackageResponse updateAdPackage(Long id, AdPackageCreateRequest request) {

        Optional<AdPackage> adOptional = adPackageRepository.findById(id);

        AdPackage adPackage = adOptional.get();
        adPackage.setNumberOfAds(request.numberOfAds());
        adPackage.setValidityPeriod(request.validityPeriod());
        adPackage.setExpirationDate(request.expirationDate());
        adPackage.setStatus(request.status());
        adPackageRepository.save(adPackage);

        return adPackageMapper.mapToAdPackageResponse(adPackage);
    }

}

