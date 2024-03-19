package com.seatech.clientapi.util.mapstruct;

import com.seatech.clientapi.entity.Telefone;
import com.seatech.clientapi.entity.dto.entity.TelefoneDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.WARN)
public interface TelefoneMapper {
    List<Telefone> listTelefonesToEntity(List<TelefoneDTO> telefones);

    default Telefone mapStringToTelefone(String telefone) {
        return Telefone.builder().numero(telefone).build();
    }

}
