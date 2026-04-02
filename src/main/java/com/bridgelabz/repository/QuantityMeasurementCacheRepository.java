package com.bridgelabz.repository;

import com.bridgelabz.model.QuantityMeasurementEntity;
import java.util.*;

public class QuantityMeasurementCacheRepository implements IQuantityMeasurementRepository {

    private static QuantityMeasurementCacheRepository instance;
    private List<QuantityMeasurementEntity> list = new ArrayList<>();

    private QuantityMeasurementCacheRepository() {}

    public static QuantityMeasurementCacheRepository getInstance() {
        if (instance == null) {
            instance = new QuantityMeasurementCacheRepository();
        }
        return instance;
    }

    public void save(QuantityMeasurementEntity entity) {
        list.add(entity);
    }

    public List<QuantityMeasurementEntity> findAll() {
        return list;
    }
}