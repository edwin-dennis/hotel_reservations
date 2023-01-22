package com.hotel.reservations.handlers;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
public class ResponseException extends RuntimeException implements Serializable {
    private int code;
    private Date timestamp;
    private String message;
    private String description;
    private Object data;
    private String traceID;
    private static final String INCORRECT_INFORMATION = "Información Incorrecta";

    public ResponseException(String description, Object data){
        this.code = 400;
        this.message = INCORRECT_INFORMATION;
        this.description = description;
        this.data = data;
    }

    public ResponseException(String description){
        this.code = 400;
        this.message = INCORRECT_INFORMATION;
        this.description = description;
    }

    public ResponseException(int code, String description){
        this.code = code;
        this.message = INCORRECT_INFORMATION;
        this.description = description;
    }
}
