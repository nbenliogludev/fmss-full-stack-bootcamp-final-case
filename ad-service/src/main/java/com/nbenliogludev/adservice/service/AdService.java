package com.nbenliogludev.adservice.service;

import com.nbenliogludev.adservice.dto.request.AdCreateRequest;
import com.nbenliogludev.adservice.dto.response.AdResponse;

import java.util.List;

public interface AdService {
    AdResponse createAd(AdCreateRequest request);

    List<AdResponse> getAllAds();

    AdResponse getAdById(Long id);

    AdResponse updateAd(Long id, AdCreateRequest userDetails);

    void deleteAd(Long id);
}
