package com.seatech.clientapi.util.mapstruct;

import com.seatech.clientapi.entity.Endereco;
import com.seatech.clientapi.entity.dto.response.CEPIntegrationResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.WARN)
public interface EnderecoMapper {

    @Mapping(target = "cep", expression = "java(cepConverter(dto.getCep()))")
    Endereco cepIntegrationToEntity(CEPIntegrationResponseDTO dto);

    @Named("cepConverter")
    default Long cepConverter(String fullCep) {
        return Long.valueOf(fullCep.replace("-", ""));
    }

}
