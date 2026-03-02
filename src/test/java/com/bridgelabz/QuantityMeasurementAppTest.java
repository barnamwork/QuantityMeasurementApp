package com.bridgelabz;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuantityMeasurementAppTest {

    private static final double EPS = 1e-6;

    @Test
    void testAddition_ExplicitTargetUnit_Feet() {
        var a = new QuantityMeasurementApp.QuantityLength(1.0, LengthUnit.FEET);
        var b = new QuantityMeasurementApp.QuantityLength(12.0, LengthUnit.INCH);

        var sum = a.add(b, LengthUnit.FEET);

        assertEquals(2.0, sum.getValue(), EPS);
        assertEquals(LengthUnit.FEET, sum.getUnit());
    }

    @Test
    void testAddition_ExplicitTargetUnit_Inches() {
        var a = new QuantityMeasurementApp.QuantityLength(1.0, LengthUnit.FEET);
        var b = new QuantityMeasurementApp.QuantityLength(12.0, LengthUnit.INCH);

        var sum = a.add(b, LengthUnit.INCH);

        assertEquals(24.0, sum.getValue(), EPS);
        assertEquals(LengthUnit.INCH, sum.getUnit());
    }

    @Test
    void testAddition_ExplicitTargetUnit_Yards() {
        var a = new QuantityMeasurementApp.QuantityLength(1.0, LengthUnit.FEET);
        var b = new QuantityMeasurementApp.QuantityLength(12.0, LengthUnit.INCH);

        var sum = a.add(b, LengthUnit.YARDS);

        assertEquals(2.0 / 3.0, sum.getValue(), EPS);
        assertEquals(LengthUnit.YARDS, sum.getUnit());
    }

    @Test
    void testAddition_ExplicitTargetUnit_Centimeters() {
        var a = new QuantityMeasurementApp.QuantityLength(1.0, LengthUnit.INCH);
        var b = new QuantityMeasurementApp.QuantityLength(1.0, LengthUnit.INCH);

        var sum = a.add(b, LengthUnit.CENTIMETERS);

        assertEquals(5.08, sum.getValue(), 1e-3);
        assertEquals(LengthUnit.CENTIMETERS, sum.getUnit());
    }

    @Test
    void testAddition_WithZero() {
        var a = new QuantityMeasurementApp.QuantityLength(5.0, LengthUnit.FEET);
        var b = new QuantityMeasurementApp.QuantityLength(0.0, LengthUnit.INCH);

        var sum = a.add(b, LengthUnit.YARDS);

        assertEquals(5.0 / 3.0, sum.getValue(), EPS);
        assertEquals(LengthUnit.YARDS, sum.getUnit());
    }

    @Test
    void testAddition_NegativeValues() {
        var a = new QuantityMeasurementApp.QuantityLength(5.0, LengthUnit.FEET);
        var b = new QuantityMeasurementApp.QuantityLength(-2.0, LengthUnit.FEET);

        var sum = a.add(b, LengthUnit.INCH);

        assertEquals(36.0, sum.getValue(), EPS);
        assertEquals(LengthUnit.INCH, sum.getUnit());
    }

    @Test
    void testAddition_NullTargetUnit_Throws() {
        var a = new QuantityMeasurementApp.QuantityLength(1.0, LengthUnit.FEET);
        var b = new QuantityMeasurementApp.QuantityLength(12.0, LengthUnit.INCH);

        assertThrows(NullPointerException.class, () -> a.add(b, null));
    }
}