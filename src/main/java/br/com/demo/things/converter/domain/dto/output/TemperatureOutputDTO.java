package br.com.demo.things.converter.domain.dto.output;

import br.com.demo.things.converter.domain.Temperature;

public class TemperatureOutputDTO {

    private Double result;
    private Temperature temperature;

    @Deprecated
    public TemperatureOutputDTO() {

    }

    public TemperatureOutputDTO(Double result, Temperature temperature) {
        this.result = result;
        this.temperature = temperature;
    }

    public Double getResult() {
        return result;
    }

    public Temperature getTemperature() {
        return temperature;
    }
}