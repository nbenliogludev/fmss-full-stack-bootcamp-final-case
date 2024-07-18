package com.nbenliogludev.adservice.service.Impl;

import com.nbenliogludev.adservice.mapper.AdMapper;
import com.nbenliogludev.adservice.service.AdService;
import com.nbenliogludev.adservice.dto.request.AdCreateRequest;
import com.nbenliogludev.adservice.dto.response.AdResponse;
import com.nbenliogludev.adservice.entity.Ad;
import com.nbenliogludev.adservice.repository.AdRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author nbenliogludev
 */
@Service
@RequiredArgsConstructor
public class AdServiceImpl implements AdService {

    private final AdRepository adRepository;
    private final AdMapper adMapper;

    @Override
    public AdResponse createAd(AdCreateRequest request) {

        Ad ad = adMapper.mapAdCreateRequestToAd(request);
        ad = adRepository.save(ad);

        return adMapper.mapToAdResponse(ad);
    }

    @Override
    public List<AdResponse> getAllAds() {

        List<Ad> users = adRepository.findAll();

        return users.stream()
                .map(adMapper::mapToAdResponse)
                .toList();
    }

    @Override
    public AdResponse getAdById(Long id) {

        Optional<Ad> userOptional = adRepository.findById(id);


        return adMapper.mapToAdResponse(userOptional.get());
    }

    @Override
    public AdResponse updateAd(Long id, AdCreateRequest request) {

        Optional<Ad> adOptional = adRepository.findById(id);


        Ad ad = adOptional.get();
        ad.setTitle(request.title());
        ad.setDescription(request.description());
        ad.setStatus(request.status());
        adRepository.save(ad);

        return adMapper.mapToAdResponse(ad);
    }

    @Override
    public void deleteAd(Long id) {

        adRepository.deleteById(id);
    }
}

