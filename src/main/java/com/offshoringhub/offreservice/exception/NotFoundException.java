package com.offshoringhub.offreservice.exception;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class NotFoundException extends RuntimeException{
    String codeError;
    String messageError;

    public NotFoundException(String messageError){
        super(messageError);
        this.messageError=messageError;
    }
}
