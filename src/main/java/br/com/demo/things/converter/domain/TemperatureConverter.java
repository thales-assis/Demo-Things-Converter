package br.com.demo.things.converter.domain;

public interface TemperatureConverter {

    Double toCelsius(Double value);

    Double toFahrenheit(Double value);

    Double toKelvin(Double value);

}