package com.seatech.clientapi.util.validator;

import com.seatech.clientapi.entity.enums.TipoTelefoneEnum;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class TipoTelefoneValidator implements ConstraintValidator<TipoTelefone, String> {

    private final static String TIPO_BLANK = "Tipo inválido: Tipo vazio";
    private final static String TIPO_NULL = "Tipo inválido: Forneça um Tipo(Celular, Residencial, Comercial)";

    @Override
    public void initialize(TipoTelefone constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String tipoTelefone, ConstraintValidatorContext constraintValidatorContext) {
        if (tipoTelefone != null) {
            return TipoTelefoneEnum.containsTipo(tipoTelefone.toUpperCase());
        }

        return false;
    }

}
