package com.nbenliogludev.adservice.repository;

import com.nbenliogludev.adservice.entity.Ad;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author nbenliogludev
 */
public interface AdRepository extends JpaRepository<Ad, Long> {

}

