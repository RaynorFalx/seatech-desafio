package com.seatech.clientapi.util.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = TipoTelefoneValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface TipoTelefone {
    String message() default "Tipo inválido: Forneça um dos tipos: Celular, Residencial, Comercial";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}