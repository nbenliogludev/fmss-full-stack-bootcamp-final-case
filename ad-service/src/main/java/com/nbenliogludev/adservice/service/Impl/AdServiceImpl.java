package com.nbenliogludev.adservice.service.Impl;

import com.nbenliogludev.adservice.exception.AdNotFoundException;
import com.nbenliogludev.adservice.mapper.AdMapper;
import com.nbenliogludev.adservice.service.AdService;
import com.nbenliogludev.adservice.dto.request.AdCreateRequest;
import com.nbenliogludev.adservice.dto.response.AdResponse;
import com.nbenliogludev.adservice.entity.Ad;
import com.nbenliogludev.adservice.repository.AdRepository;
import com.nbenliogludev.adservice.util.AppLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdServiceImpl implements AdService {

    private final AdRepository adRepository;
    private final AdMapper adMapper;
    private final AppLogger appLogger;

    @Override
    public AdResponse createAd(AdCreateRequest request) {
        Ad ad = adMapper.mapAdCreateRequestToAd(request);
        ad = adRepository.save(ad);
        appLogger.logInfo("AdServiceImpl", "Ad created with id: " + ad.getId());
        return adMapper.mapToAdResponse(ad);
    }

    @Override
    public List<AdResponse> getAllAds() {
        appLogger.logInfo("AdServiceImpl", "Fetching all ads");
        List<Ad> ads = adRepository.findAll();
        appLogger.logInfo("AdServiceImpl", "Fetched " + ads.size() + " ads");
        return ads.stream()
                .map(adMapper::mapToAdResponse)
                .toList();
    }

    @Override
    public AdResponse getAdById(Long id) {
        appLogger.logInfo("AdServiceImpl", "Fetching ad by id: " + id);
        Optional<Ad> adOptional = adRepository.findById(id);
        if (adOptional.isPresent()) {
            appLogger.logInfo("AdServiceImpl", "Ad found with id: " + id);
            return adMapper.mapToAdResponse(adOptional.get());
        } else {
            appLogger.logInfo("AdServiceImpl", "No ad found with id: " + id);
            throw new AdNotFoundException("Ad not found with id: " + id);
        }
    }

    @Override
    public AdResponse updateAd(Long id, AdCreateRequest request) {
        appLogger.logInfo("AdServiceImpl", "Updating ad with id: " + id);
        Ad ad = adRepository.findById(id)
                .orElseThrow(() -> new AdNotFoundException("Ad not found with id: " + id));

        ad.setTitle(request.title());
        ad.setDescription(request.description());
        ad.setStatus(request.status());
        adRepository.save(ad);
        appLogger.logInfo("AdServiceImpl", "Updated ad with id: " + id);
        return adMapper.mapToAdResponse(ad);
    }

    @Override
    public void deleteAd(Long id) {
        appLogger.logInfo("AdServiceImpl", "Deleting ad with id: " + id);
        adRepository.deleteById(id);
        appLogger.logInfo("AdServiceImpl", "Deleted ad with id: " + id);
    }
}
