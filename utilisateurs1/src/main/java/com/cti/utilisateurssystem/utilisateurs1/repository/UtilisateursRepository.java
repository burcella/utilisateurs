package com.cti.utilisateurssystem.utilisateurs1.repository;

import com.cti.utilisateurssystem.utilisateurs1.models.Utilisateurs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateursRepository extends JpaRepository<Utilisateurs , Long> {

    Utilisateurs findByEmail(String email);
}
