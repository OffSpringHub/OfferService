package com.offshoringhub.offreservice.exception;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NotAuthorizedException extends RuntimeException{
    String codeError;
    String messageError;

    public NotAuthorizedException(String messageError){
        super(messageError);
        this.messageError=messageError;
    }
}
