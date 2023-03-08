package com.cti.utilisateurssystem.utilisateurs1.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UtilisateurExceptionHandler {
    @ExceptionHandler(value = UtilisateursNotFoundException .class)
    public ResponseEntity<Object> notFoundException(UtilisateursNotFoundException  exception){
        return new ResponseEntity<>( "Utilisateurs not found", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = UtilisateursBadRequestException.class)
    public ResponseEntity<Object> badRequestException(UtilisateursBadRequestException  exception){
        return new ResponseEntity<>( "users does not created", HttpStatus.BAD_REQUEST);
    }

}
