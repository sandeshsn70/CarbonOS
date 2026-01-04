package com.carbonos.backend.controller;

import com.carbonos.backend.model.ActivityData;
import com.carbonos.backend.model.CarbonActivity;
import com.carbonos.backend.service.CarbonService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/carbon")
public class CarbonController {

    private final CarbonService carbonService;

    public CarbonController(CarbonService carbonService) {
        this.carbonService = carbonService;
    }

    // 🔥 ML POWERED ENDPOINT
    @PostMapping("/predict")
    public CarbonActivity predict(@RequestBody ActivityData data) {
        return carbonService.predictAndSave(data);
    }
}
