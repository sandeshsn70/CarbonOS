package com.carbonos.backend.service;

import com.carbonos.backend.model.ActivityData;
import com.carbonos.backend.model.CarbonActivity;
import com.carbonos.backend.model.MLResponse;
import com.carbonos.backend.repository.CarbonActivityRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CarbonService {

    private final CarbonActivityRepository repository;
    private final RestTemplate restTemplate;

    private static final String ML_URL = "http://localhost:5000/predict";

    public CarbonService(CarbonActivityRepository repository,
                         RestTemplate restTemplate) {
        this.repository = repository;
        this.restTemplate = restTemplate;
    }

    public CarbonActivity predictAndSave(ActivityData data) {

        // 🔁 Call Flask ML
        MLResponse mlResponse =
                restTemplate.postForObject(ML_URL, data, MLResponse.class);

        if (mlResponse == null) {
            throw new RuntimeException("ML service not responding");
        }

        // 💾 Save to DB
        CarbonActivity activity = new CarbonActivity();
        activity.setActivityType(data.getActivityType());
        activity.setFuelType(data.getFuelType());
        activity.setActivityValue(data.getValue());
        activity.setEmission(mlResponse.getPredictedEmission());

        return repository.save(activity);
    }
}
