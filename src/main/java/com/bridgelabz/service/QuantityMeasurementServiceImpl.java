package com.bridgelabz.service;

import com.bridgelabz.*;
import com.bridgelabz.exception.QuantityMeasurementException;
import com.bridgelabz.model.QuantityDTO;
import com.bridgelabz.repository.IQuantityMeasurementRepository;

@SuppressWarnings({"unchecked", "rawtypes"})
public class QuantityMeasurementServiceImpl implements IQuantityMeasurementService {

    private final IQuantityMeasurementRepository repository;

    public QuantityMeasurementServiceImpl(IQuantityMeasurementRepository repository) {
        this.repository = repository;
    }

    // ================= DTO → Quantity =================

    private Quantity toQuantity(QuantityDTO dto) {

        switch (dto.getUnit()) {

            case "FEET":
                return new Quantity(dto.getValue(), LengthUnit.FEET);

            case "INCH":
            case "INCHES":
                return new Quantity(dto.getValue(), LengthUnit.INCHES);

            case "KILOGRAM":
                return new Quantity(dto.getValue(), WeightUnit.KILOGRAM);

            case "GRAM":
                return new Quantity(dto.getValue(), WeightUnit.GRAM);

            case "LITRE":
                return new Quantity(dto.getValue(), VolumeUnit.LITRE);

            case "MILLILITRE":
                return new Quantity(dto.getValue(), VolumeUnit.MILLILITRE);

            case "CELSIUS":
                return new Quantity(dto.getValue(), TemperatureUnit.CELSIUS);

            case "FAHRENHEIT":
                return new Quantity(dto.getValue(), TemperatureUnit.FAHRENHEIT);

            default:
                throw new QuantityMeasurementException("Invalid Unit: " + dto.getUnit());
        }
    }

    // ================= OPERATIONS =================

    @Override
    public boolean compare(QuantityDTO q1, QuantityDTO q2) {
        return toQuantity(q1).equals(toQuantity(q2));
    }

    @Override
    public QuantityDTO add(QuantityDTO q1, QuantityDTO q2) {

        Quantity qA = toQuantity(q1);
        Quantity qB = toQuantity(q2);

        Quantity result = Quantity.add(qA, qB);

        return new QuantityDTO(result.getValue(), result.getUnit().getUnitName());
    }

    @Override
    public QuantityDTO subtract(QuantityDTO q1, QuantityDTO q2) {

        Quantity qA = toQuantity(q1);
        Quantity qB = toQuantity(q2);

        Quantity result = qA.subtract(qB);

        return new QuantityDTO(result.getValue(), result.getUnit().getUnitName());
    }

    @Override
    public double divide(QuantityDTO q1, QuantityDTO q2) {

        Quantity qA = toQuantity(q1);
        Quantity qB = toQuantity(q2);

        return qA.divide(qB);
    }

    @Override
    public QuantityDTO convert(QuantityDTO q, String targetUnit) {

        Quantity quantity = toQuantity(q);

        IMeasurable unit = switch (targetUnit) {

            case "FEET" -> LengthUnit.FEET;
            case "INCHES" -> LengthUnit.INCHES;

            case "KILOGRAM" -> WeightUnit.KILOGRAM;
            case "GRAM" -> WeightUnit.GRAM;

            case "LITRE" -> VolumeUnit.LITRE;
            case "MILLILITRE" -> VolumeUnit.MILLILITRE;

            case "CELSIUS" -> TemperatureUnit.CELSIUS;
            case "FAHRENHEIT" -> TemperatureUnit.FAHRENHEIT;

            default -> throw new QuantityMeasurementException("Invalid target unit");
        };

        Quantity result = quantity.convertTo(unit);

        return new QuantityDTO(result.getValue(), targetUnit);
    }
}