package com.bridgelabz.app;

import com.bridgelabz.controller.*;
import com.bridgelabz.model.*;
import com.bridgelabz.repository.*;
import com.bridgelabz.service.*;

public class QuantityMeasurementApp {

    public static void main(String[] args) {

        IQuantityMeasurementRepository repo =
                QuantityMeasurementCacheRepository.getInstance();

        IQuantityMeasurementService service =
                new QuantityMeasurementServiceImpl(repo);

        QuantityMeasurementController controller =
                new QuantityMeasurementController(service);

        controller.performAddition(
                new QuantityDTO(1, "FEET"),
                new QuantityDTO(12, "INCH")
        );

        controller.performComparison(
                new QuantityDTO(1, "FEET"),
                new QuantityDTO(12, "INCH")
        );
    }
}