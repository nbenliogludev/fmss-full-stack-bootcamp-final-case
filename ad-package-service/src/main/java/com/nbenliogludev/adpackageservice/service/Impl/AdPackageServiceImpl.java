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

        List<AdPackage> users = adPackageRepository.findAll();

        return users.stream()
                .map(adPackageMapper::mapToAdPackageResponse)
                .toList();
    }

}

