package com.bridgelabz.controller;

import com.bridgelabz.model.QuantityDTO;
import com.bridgelabz.service.IQuantityMeasurementService;

public class QuantityMeasurementController {

    private final IQuantityMeasurementService service;

    public QuantityMeasurementController(IQuantityMeasurementService service) {
        this.service = service;
    }

    public void performAddition(QuantityDTO q1, QuantityDTO q2) {
        System.out.println(service.add(q1, q2));
    }

    public void performComparison(QuantityDTO q1, QuantityDTO q2) {
        System.out.println(service.compare(q1, q2));
    }
}