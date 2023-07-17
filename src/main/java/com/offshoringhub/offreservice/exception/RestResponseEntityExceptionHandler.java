package com.offshoringhub.offreservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorException OfferNotFoundHandler(NotFoundException notFoundException){
        return new ErrorException(HttpStatus.NOT_FOUND,notFoundException.getMessageError());
    }


    @ExceptionHandler(NotAuthorizedException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ErrorException UnauthorizedHandler(NotAuthorizedException notAuthorizedException){
        return new ErrorException(HttpStatus.UNAUTHORIZED,notAuthorizedException.getMessageError());
    }
}
