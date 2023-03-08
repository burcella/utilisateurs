package com.cti.utilisateurssystem.utilisateurs1.Exception;

public class UtilisateursNotFoundException extends RuntimeException{
    public UtilisateursNotFoundException(Long utilisateurId){
        super("no utilisateurs found with id");
    }
}
