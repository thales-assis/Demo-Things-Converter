package br.com.demo.things.converter.domain;

import br.com.demo.things.converter.service.exception.ExpectedInvalidTypeException;

import java.math.BigDecimal;
import java.math.RoundingMode;

public enum Temperature implements TemperatureConverter {

    CELSIUS {
        @Override
        public Double toCelsius(Double value) {
            return value;
        }

        @Override
        public Double toFahrenheit(Double value) {
            // Mathematical Expression: 1 °C * 1.800 + 32 = 33.80 °F || 1 °C × 9/5 + 32 = 33.8 °F
            return new BigDecimal(value).multiply(new BigDecimal(1.800)).add(new BigDecimal(32.000)).setScale(2, RoundingMode.HALF_UP).doubleValue();

        }

        @Override
        public Double toKelvin(Double value) {
            // Mathematical Expression: 1 °C + 273.15 = 274.15 K
            return new BigDecimal(value).add(new BigDecimal(273.150)).setScale(2, RoundingMode.HALF_UP).doubleValue();
        }
    },
    FAHRENHEIT {
        @Override
        public Double toCelsius(Double value) {
            // Mathematical Expression: (33.8 °F − 32) / 1.800 = 1 °C || (33.8 °F − 32) × 5/9 = 1 °C
            return new BigDecimal(value).subtract(new BigDecimal(32.000)).divide(new BigDecimal(1.800), 2, RoundingMode.HALF_UP).setScale(2, RoundingMode.HALF_UP).doubleValue();
        }

        @Override
        public Double toFahrenheit(Double value) {
            return value;
        }

        @Override
        public Double toKelvin(Double value) {
            // Mathematical Expression: (33.8 °F − 32) / 1.800 + 273.15 = 274.15 K || (33.8 °F − 32) × 5/9 + 273.15 = 274.15 K
            return new BigDecimal(value).subtract(new BigDecimal(32.000)).divide(new BigDecimal(1.800), 2, RoundingMode.HALF_UP).add(new BigDecimal(273.150)).setScale(2, RoundingMode.HALF_UP).doubleValue();
        }
    },
    KELVIN {
        @Override
        public Double toCelsius(Double value) {
            // Mathematical Expression: 274.15 K - 273.15 = 1 °C
            return new BigDecimal(value).subtract(new BigDecimal(273.150)).setScale(2, RoundingMode.HALF_UP).doubleValue();
        }

        @Override
        public Double toFahrenheit(Double value) {
            // Mathematical Expression: (274.15 K − 273.15) * 1.800 + 32 = 33.80 °F || (274.15 K − 273.15) × 9/5 + 32 = 33.8 °F
            return new BigDecimal(value).subtract(new BigDecimal(273.150)).multiply(new BigDecimal(1.800)).add(new BigDecimal(32.000)).setScale(2, RoundingMode.HALF_UP).doubleValue();
        }

        @Override
        public Double toKelvin(Double value) {
            return value;
        }
    };

    public Double converterToAnotherTemperature(Temperature anotherTemperature, Double value) {
        switch (anotherTemperature) {
            case CELSIUS:
                return this.toCelsius(value);
            case FAHRENHEIT:
                return this.toFahrenheit(value);
            case KELVIN:
                return this.toKelvin(value);
            default:
                throw new ExpectedInvalidTypeException("The expected temperature type is invalid");
        }
    }

}