package com.cti.utilisateurssystem.utilisateurs1.controller;

import com.cti.utilisateurssystem.utilisateurs1.dto.UtilisateursRequest;
import com.cti.utilisateurssystem.utilisateurs1.dto.UtilisateursResponse;
import com.cti.utilisateurssystem.utilisateurs1.models.Utilisateurs;
import com.cti.utilisateurssystem.utilisateurs1.servive.UtilisateursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/utilisateurs")
public class UtilisateusController {
    @Autowired
    UtilisateursService utilisateursService;
    @PostMapping("/create")

    public ResponseEntity<UtilisateursResponse> createdutilisateur(@RequestBody UtilisateursRequest utilisateurs){
        return utilisateursService.createUtilisateur(utilisateurs);
    }
    @GetMapping("/all")
    public List<Utilisateurs> getAllUtilisateurs(){
        return  utilisateursService.AllUtilisateurs();
    }
    @GetMapping("/find/id/{id}")
    public Utilisateurs getUtilisateurById(@PathVariable Long id){
        return utilisateursService.utilisateursById(id);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteUtilisateursById(@PathVariable Long id){
         utilisateursService.deleteById(id);
         return ("ok");
    }
    @PutMapping("/update")
    public ResponseEntity<UtilisateursResponse> updateUtilisateursById(@RequestBody UtilisateursRequest utilisateursRequest){
        return utilisateursService.update(utilisateursRequest);
    }
    @PostMapping("/activated/{id}")
    public ResponseEntity<UtilisateursResponse> activatedUtilisateurs(@PathVariable Long id){
        return  utilisateursService.activated(id);
    }
}
