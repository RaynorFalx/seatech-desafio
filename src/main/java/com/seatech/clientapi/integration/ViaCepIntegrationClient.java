package com.seatech.clientapi.integration;

import com.seatech.clientapi.entity.dto.response.CEPIntegrationResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "CepIntegrationService", url = "${integration.viacep.url}")
public interface ViaCepIntegrationClient {

    @GetMapping(path = "/{cep}/json/", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public CEPIntegrationResponseDTO getCep(@PathVariable(name = "cep") String cep);

}
