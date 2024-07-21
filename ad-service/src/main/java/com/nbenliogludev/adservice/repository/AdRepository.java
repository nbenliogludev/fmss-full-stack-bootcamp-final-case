package com.nbenliogludev.adservice.repository;

import com.nbenliogludev.adservice.entity.Ad;
import com.nbenliogludev.adservice.enums.AdStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author nbenliogludev
 */
public interface AdRepository extends JpaRepository<Ad, Long> {
    @Query("SELECT a FROM Ad a WHERE a.status <> :status")
    List<Ad> findAllByStatusNot(@Param("status") AdStatus status);

}

