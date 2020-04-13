package br.com.demo.things.converter.service;

import br.com.demo.things.converter.domain.dto.input.TemperatureInputDTO;
import br.com.demo.things.converter.domain.dto.output.TemperatureOutputDTO;
import org.springframework.stereotype.Service;

@Service
public class TemperatureService {

    public TemperatureOutputDTO converterTemperature(TemperatureInputDTO inputDTO) {
        Double result = inputDTO.getSourceTemperature().converterToAnotherTemperature(inputDTO.getTargetTemperature(), inputDTO.getValue());
        return new TemperatureOutputDTO(result, inputDTO.getTargetTemperature());
    }
    
}