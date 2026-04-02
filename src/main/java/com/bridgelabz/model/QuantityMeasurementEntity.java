package com.bridgelabz.model;

public class QuantityMeasurementEntity {

    private final QuantityDTO q1;
    private final QuantityDTO q2;
    private final String operation;
    private final Object result;
    private final String error;

    public QuantityMeasurementEntity(QuantityDTO q1, QuantityDTO q2, String operation, Object result) {
        this.q1 = q1;
        this.q2 = q2;
        this.operation = operation;
        this.result = result;
        this.error = null;
    }

    public QuantityMeasurementEntity(QuantityDTO q1, QuantityDTO q2, String operation, String error) {
        this.q1 = q1;
        this.q2 = q2;
        this.operation = operation;
        this.error = error;
        this.result = null;
    }
}