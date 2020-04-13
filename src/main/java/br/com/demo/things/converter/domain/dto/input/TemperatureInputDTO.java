package br.com.demo.things.converter.domain.dto.input;

import br.com.demo.things.converter.domain.Temperature;

public class TemperatureInputDTO {

    private Temperature sourceTemperature;
    private Double value;
    private Temperature targetTemperature;

    @Deprecated
    public TemperatureInputDTO() {

    }

    public TemperatureInputDTO(Temperature sourceTemperature, Double value, Temperature targetTemperature) {
        this.sourceTemperature = sourceTemperature;
        this.value = value;
        this.targetTemperature = targetTemperature;
    }

    public Temperature getSourceTemperature() {
        return sourceTemperature;
    }

    public Double getValue() {
        return value;
    }

    public Temperature getTargetTemperature() {
        return targetTemperature;
    }
}