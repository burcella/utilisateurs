package com.cti.utilisateurssystem.utilisateurs1.dto;

import jakarta.persistence.*;
import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UtilisateursRequest {

    private String nom;
    private String email;
    private String phone;
    private String password;
    private Boolean isActive;
}
