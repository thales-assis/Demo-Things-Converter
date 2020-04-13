package br.com.demo.things.converter.resource;

import br.com.demo.things.converter.domain.dto.input.TemperatureInputDTO;
import br.com.demo.things.converter.domain.dto.output.TemperatureOutputDTO;
import br.com.demo.things.converter.service.TemperatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/${api.version}/converter/temperature")
public class TemperatureResource {

    @Autowired
    TemperatureService temperatureService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TemperatureOutputDTO> converterTemperature(@RequestBody TemperatureInputDTO inputDTO) {
        TemperatureOutputDTO outputDTO = temperatureService.converterTemperature(inputDTO);
        return ResponseEntity.ok().body(outputDTO);
    }

}