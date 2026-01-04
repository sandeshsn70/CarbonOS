package com.carbonos.backend.repository;

import com.carbonos.backend.model.CarbonActivity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarbonActivityRepository
        extends JpaRepository<CarbonActivity, Long> {
}
