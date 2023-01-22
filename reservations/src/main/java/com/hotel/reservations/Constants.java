package com.hotel.reservations;

import com.hotel.reservations.handlers.Response;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

@Slf4j
public class Constants {


    public static final int CODE_INVALID_FIELD = -1;
    public static final int CODE_FORDBIDEN = 403;
    public static final int CODE_INVALID = 400;
    public static final int CODE_NEW_EVENT = 201;
    public static final int CODE_SERVER_ERROR = 500;
    public static final int CODE_200= 200;


    public static final String EMPTY="";
    public static final String REQUEST_ACCEPTED = "Request Accepted";
    public static final String SUCCESSFUL_UPDATE = "successful update";
    public static final String SUCCESSFUL_INSERTION = "successful insertion";
    public static final String SERVER_ERROR = "Server Error";
    public static final String ACCESS_DENIED = "Access denied";
    public static final String ERROR = "Error";

    public static final String INCORRECT_INFORMATION = "the information does not exist in the database";
    public static final String DESCRIPTION_SUCCESSFUL_INSERTION = "The information was saved correctly";
    public static final String DESCRIPTION_SUCCESSFUL_UPDATE = "The information was correctly updated";
    public static final String DESCRIPTION_ERROR_FIELDS = "One or more fields are incorrect";




    public static Response incorrectInformation(){
        return new Response(CODE_INVALID,new Date(),INCORRECT_INFORMATION,EMPTY,EMPTY,EMPTY);
    }

    public static Response incorrectInformation(int code, String message){
        return new Response(code,new Date(),message,EMPTY,EMPTY,EMPTY);
    }

    public static Response serverError(){
        return new Response(CODE_SERVER_ERROR,new Date(),ERROR,SERVER_ERROR,EMPTY,EMPTY);
    }

    public static Response incorrectField(Object data){
        return new Response(CODE_INVALID_FIELD,new Date(),INCORRECT_INFORMATION,DESCRIPTION_ERROR_FIELDS,data,EMPTY);
    }


    public static Response successfulSaved(Object data){
        log.info(SUCCESSFUL_INSERTION,data);
        return new Response(CODE_NEW_EVENT,new Date(),SUCCESSFUL_INSERTION,DESCRIPTION_SUCCESSFUL_INSERTION,data,EMPTY);
    }

    public static Response successfullyUpdated(Object data){
        return new Response(CODE_NEW_EVENT,new Date(),SUCCESSFUL_UPDATE,DESCRIPTION_SUCCESSFUL_UPDATE,data,EMPTY);
    }

    public static Response success(Object data) {
        return new Response(CODE_200, new Date(), REQUEST_ACCEPTED, "Information is provided", data, EMPTY);
    }


}
