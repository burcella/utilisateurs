package com.cti.utilisateurssystem.utilisateurs1.Exception;

public class UtilisateursBadRequestException extends RuntimeException{
    public UtilisateursBadRequestException(String message){
        super("error request" +message);
    }
}
