package com.seatech.clientapi.exception;

import com.seatech.clientapi.exception.dto.NegocialExceptionDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(UNPROCESSABLE_ENTITY)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, List<String>>> handleValidationErrors(MethodArgumentNotValidException ex) {
        return new ResponseEntity<>(getErrorsMap(makeErrorList(ex)), new HttpHeaders(), UNPROCESSABLE_ENTITY);
    }

    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler(NegocialException.class)
    public ResponseEntity<NegocialExceptionDTO> handleNegocialErrors(NegocialException ex) {
        return new ResponseEntity<>(makeNegocialExceptionDTO(ex), null, BAD_REQUEST);
    }

    private List<String> makeErrorList(MethodArgumentNotValidException ex) {
        return ex.getBindingResult().getFieldErrors()
                .stream().map(FieldError::getDefaultMessage).collect(Collectors.toList());
    }

    private Map<String, List<String>> getErrorsMap(List<String> errors) {
        Map<String, List<String>> errorResponse = new HashMap<>();
        errorResponse.put("errors", errors);
        return errorResponse;
    }

    private NegocialExceptionDTO makeNegocialExceptionDTO(NegocialException exception) {
        return NegocialExceptionDTO.builder()
                .codigoStatusHttp(exception.getCodigoStatusHttp())
                .causaErro(exception.getCausaErro())
                .build();
    }

}
