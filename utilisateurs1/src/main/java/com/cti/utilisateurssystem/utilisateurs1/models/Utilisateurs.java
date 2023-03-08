package com.cti.utilisateurssystem.utilisateurs1.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_utilisateurs")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Utilisateurs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    @Column(name = "utilisateurs_nom")
    private String nom;
    @NonNull
    @Column(name = "utilisateurs_email")
    private String email;
    @NonNull
    @Column(name = "utilisateurs_phone")
    private String phone;
    @NonNull
    @Column(name = "utilisateurs_password")
    private String password;
    @NonNull
    @Column(name = "utilisateurs_isActive")
    private Boolean isActive;
}
