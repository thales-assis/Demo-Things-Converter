package br.com.demo.things.converter.domain;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TemperatureTests {

    private Temperature celsius;
    private Temperature fahrenheit;
    private Temperature kelvin;

    @Before
    public void setup() {
        this.celsius = Temperature.CELSIUS;
        this.fahrenheit = Temperature.FAHRENHEIT;
        this.kelvin = Temperature.KELVIN;
    }

    @Test
    public void mustReturnTheSameValueCelsiusToCelsius() {
        Double value = Double.valueOf(48.29);

        Double expectedValue = this.celsius.toCelsius(value);

        assertThat(expectedValue).isEqualTo(value);
    }

    @Test
    public void shouldConvertCelsiusToFahrenheit() {
        Double value = Double.valueOf(27.45);

        Double expectedValue = this.celsius.toFahrenheit(value);

        assertThat(expectedValue).isEqualTo(81.41);
    }

    @Test
    public void shouldConvertCelsiusToKelvin() {
        Double value = Double.valueOf(27.45);

        Double expectedValue = this.celsius.toKelvin(value);

        assertThat(expectedValue).isEqualTo(300.60);
    }

    @Test
    public void shouldConvertFahrenheitToCelsius() {
        Double value = Double.valueOf(33.80);

        Double expectedValue = this.fahrenheit.toCelsius(value);

        assertThat(expectedValue).isEqualTo(1.0);
    }

    @Test
    public void mustReturnTheSameValueFahrenheitToFahrenheit() {
        Double value = Double.valueOf(-28.67);

        Double expectedValue = this.fahrenheit.toFahrenheit(value);

        assertThat(expectedValue).isEqualTo(value);
    }

    @Test
    public void shouldConvertFahrenheitToKelvin() {
        Double value = Double.valueOf(33.80);

        Double expectedValue = this.fahrenheit.toKelvin(value);

        assertThat(expectedValue).isEqualTo(274.15);
    }

    @Test
    public void shouldConvertKelvinToCelsius() {
        Double value = Double.valueOf(283.15);

        Double expectedValue = this.kelvin.toCelsius(value);

        assertThat(expectedValue).isEqualTo(10.00);
    }

    @Test
    public void shouldConvertKelvinToFahrenheit() {
        Double value = Double.valueOf(27.45);

        Double expectedValue = this.kelvin.toFahrenheit(value);

        assertThat(expectedValue).isEqualTo(-410.26);
    }

    @Test
    public void mustReturnTheSameValueKelvinToKelvin() {
        Double value = Double.valueOf(40.93);

        Double expectedValue = this.kelvin.toKelvin(value);

        assertThat(expectedValue).isEqualTo(value);
    }

}
