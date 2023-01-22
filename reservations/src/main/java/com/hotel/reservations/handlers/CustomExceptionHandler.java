package com.hotel.reservations.handlers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

import static com.hotel.reservations.Constants.*;


@ControllerAdvice
@Slf4j
public class CustomExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Object> runtimeException(RuntimeException e) {

        if(e instanceof ResponseException){
            ResponseException exception = (ResponseException) e;
            log.error(SERVER_ERROR,exception.getDescription());
            return new ResponseEntity<>(new Response(exception.getCode(),exception.getTimestamp(),
                    exception.getMessage(),exception.getDescription(),
                    exception.getData(),exception.getTraceID()),HttpStatus.ACCEPTED);
        }

        if(e instanceof HttpMessageNotReadableException){
            log.error(SERVER_ERROR,e);
            return new ResponseEntity<>(incorrectInformation(CODE_INVALID,DESCRIPTION_ERROR_FIELDS),HttpStatus.ACCEPTED);
        }

        log.error(SERVER_ERROR,e);
        return new ResponseEntity<>(serverError(),HttpStatus.ACCEPTED);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object>  exception(Exception e) {
        log.error(SERVER_ERROR,e);

        if(e instanceof MethodArgumentNotValidException){

            return new ResponseEntity<>(
                    incorrectField(getErrorsFields((MethodArgumentNotValidException) e))
                    ,HttpStatus.ACCEPTED);

        }

        if(e instanceof HttpRequestMethodNotSupportedException){

            return new ResponseEntity<>(
                    incorrectInformation(CODE_FORDBIDEN,ACCESS_DENIED)
                    ,HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>(serverError(),HttpStatus.ACCEPTED);
    }

    public  Map<String, String> getErrorsFields(MethodArgumentNotValidException ex){
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        log.error(SERVER_ERROR,errors);
        return errors;
    }


}
