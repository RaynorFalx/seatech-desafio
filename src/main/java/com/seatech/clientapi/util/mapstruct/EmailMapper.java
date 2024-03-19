package com.seatech.clientapi.util.mapstruct;

import com.seatech.clientapi.entity.Email;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.WARN)
public interface EmailMapper {

    List<Email> listEmailsToEntity(List<String> emails);

    default Email mapStringToEmail(String email) {
        return Email.builder().email(email).build();
    }

}
