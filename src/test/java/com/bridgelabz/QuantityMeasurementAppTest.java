package com.bridgelabz;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuantityMeasurementAppTest {

    private static final double EPS = 1e-6;

    // ---------- UC7 : Addition with explicit target unit ----------

    @Test
    void add_feet_and_inches_result_in_feet() {
        var a = new QuantityMeasurementApp.QuantityLength(1.0, LengthUnit.FEET);
        var b = new QuantityMeasurementApp.QuantityLength(12.0, LengthUnit.INCH);

        var sum = a.add(b, LengthUnit.FEET);

        assertEquals(2.0, sum.getValue(), EPS);
        assertEquals(LengthUnit.FEET, sum.getUnit());
    }

    @Test
    void add_feet_and_inches_result_in_inches() {
        var a = new QuantityMeasurementApp.QuantityLength(1.0, LengthUnit.FEET);
        var b = new QuantityMeasurementApp.QuantityLength(12.0, LengthUnit.INCH);

        var sum = a.add(b, LengthUnit.INCH);

        assertEquals(24.0, sum.getValue(), EPS);
        assertEquals(LengthUnit.INCH, sum.getUnit());
    }

    @Test
    void add_feet_and_inches_result_in_yards() {
        var a = new QuantityMeasurementApp.QuantityLength(1.0, LengthUnit.FEET);
        var b = new QuantityMeasurementApp.QuantityLength(12.0, LengthUnit.INCH);

        var sum = a.add(b, LengthUnit.YARDS);

        assertEquals(2.0 / 3.0, sum.getValue(), EPS);
        assertEquals(LengthUnit.YARDS, sum.getUnit());
    }

    @Test
    void add_inches_and_inches_result_in_centimeters() {
        var a = new QuantityMeasurementApp.QuantityLength(1.0, LengthUnit.INCH);
        var b = new QuantityMeasurementApp.QuantityLength(1.0, LengthUnit.INCH);

        var sum = a.add(b, LengthUnit.CENTIMETERS);

        assertEquals(5.08, sum.getValue(), 1e-3);
        assertEquals(LengthUnit.CENTIMETERS, sum.getUnit());
    }

    // ---------- UC6 : Addition in first operand unit ----------

    @Test
    void add_returns_result_in_first_operand_unit() {
        var a = new QuantityMeasurementApp.QuantityLength(1.0, LengthUnit.YARDS);
        var b = new QuantityMeasurementApp.QuantityLength(3.0, LengthUnit.FEET);

        var sum = a.add(b);

        assertEquals(2.0, sum.getValue(), EPS);
        assertEquals(LengthUnit.YARDS, sum.getUnit());
    }

    // ---------- Edge cases ----------

    @Test
    void add_with_zero_value() {
        var a = new QuantityMeasurementApp.QuantityLength(5.0, LengthUnit.FEET);
        var b = new QuantityMeasurementApp.QuantityLength(0.0, LengthUnit.INCH);

        var sum = a.add(b, LengthUnit.YARDS);

        assertEquals(5.0 / 3.0, sum.getValue(), EPS);
        assertEquals(LengthUnit.YARDS, sum.getUnit());
    }

    @Test
    void add_with_negative_values() {
        var a = new QuantityMeasurementApp.QuantityLength(5.0, LengthUnit.FEET);
        var b = new QuantityMeasurementApp.QuantityLength(-2.0, LengthUnit.FEET);

        var sum = a.add(b, LengthUnit.INCH);

        assertEquals(36.0, sum.getValue(), EPS);
        assertEquals(LengthUnit.INCH, sum.getUnit());
    }

    @Test
    void add_with_null_target_unit_throws_exception() {
        var a = new QuantityMeasurementApp.QuantityLength(1.0, LengthUnit.FEET);
        var b = new QuantityMeasurementApp.QuantityLength(12.0, LengthUnit.INCH);

        assertThrows(NullPointerException.class, () -> a.add(b, null));
    }

    @Test
    void add_with_null_quantity_throws_exception() {
        var a = new QuantityMeasurementApp.QuantityLength(1.0, LengthUnit.FEET);

        assertThrows(NullPointerException.class, () -> a.add(null, LengthUnit.FEET));
    }

    // ---------- Equality ----------

    @Test
    void equality_based_on_physical_length() {
        var feet = new QuantityMeasurementApp.QuantityLength(1.0, LengthUnit.FEET);
        var inches = new QuantityMeasurementApp.QuantityLength(12.0, LengthUnit.INCH);

        assertEquals(feet, inches);
        assertEquals(inches, feet);
    }
}