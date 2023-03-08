package com.cti.utilisateurssystem.utilisateurs1.servive;

import com.cti.utilisateurssystem.utilisateurs1.Exception.UtilisateursBadRequestException;
import com.cti.utilisateurssystem.utilisateurs1.Exception.UtilisateursNotFoundException;
import com.cti.utilisateurssystem.utilisateurs1.dto.UtilisateursRequest;
import com.cti.utilisateurssystem.utilisateurs1.dto.UtilisateursResponse;
import com.cti.utilisateurssystem.utilisateurs1.models.Utilisateurs;
import com.cti.utilisateurssystem.utilisateurs1.repository.UtilisateursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UtilisateursService {
    @Autowired
    UtilisateursRepository utilisateursRepository;

//    public UtilisateursResponse createUtilisateurs(UtilisateursRequest utilisateurs) {
//        UtilisateursRequest utilisateur1 = UtilisateursRequest.builder()
//                .nom(utilisateurs.getNom())
//                .email(utilisateurs.getEmail())
//                .phone(utilisateurs.getPhone())
//                .password(utilisateurs.getPassword())
//                .isActive(utilisateurs.getIsActive())
//                .build();
//        Utilisateurs utilisateurToSave = mapUtilisateursRequestToUtilisateurs(utilisateur1);
//        Utilisateurs utilisateurs2 = utilisateursRepository.save(utilisateurToSave);
//        System.out.println("Id Saved in database{}  %f" + utilisateurs2.getId());
//        UtilisateursResponse utilisateursResponse = UtilisateursResponse.builder()
//                .id(utilisateurs2.getId())
//                .nom(utilisateurs2.getNom())
//                .email(utilisateurs2.getEmail())
//                .phone(utilisateurs2.getPhone())
//                .password(utilisateurs2.getPassword())
//                .isActive(utilisateurs2.getIsActive())
//                .build();
//        return utilisateursResponse;
//    }
//
//    private Utilisateurs mapUtilisateursRequestToUtilisateurs(UtilisateursRequest utilisateur1) {
//        Utilisateurs utilisateurs = Utilisateurs.builder()
//                .nom(utilisateur1.getNom())
//                .email(utilisateur1.getEmail())
//                .phone(utilisateur1.getPhone())
//                .password(utilisateur1.getPassword())
//                .isActive(utilisateur1.getIsActive())
//                .build();
//        return utilisateurs;
//    }

    public List<Utilisateurs> AllUtilisateurs() {
        List<Utilisateurs> util = utilisateursRepository.findAll().stream().toList();
        return util;
    }

    public Utilisateurs utilisateursById(Long id) {
        Utilisateurs utilisateurs = utilisateursRepository.findById(id).orElseThrow(() -> new UtilisateursNotFoundException(id));
        if (utilisateurs.getId() != null) {
            return utilisateurs;
        }
        throw new UtilisateursBadRequestException("error to save user");

    }

    public void deleteById(Long id) {
        Utilisateurs utilisateurs = utilisateursRepository.findById(id).orElseThrow(() -> new UtilisateursNotFoundException(id));
        if (utilisateurs.getId() != null) {
            utilisateursRepository.deleteById(id);

        }
    }

    public ResponseEntity<UtilisateursResponse> createUtilisateur(UtilisateursRequest utilisateursRequest) {
        if (utilisateursRequest.getEmail() != null) {
            Utilisateurs utilisateurs = utilisateursRepository.findByEmail(utilisateursRequest.getEmail());
            System.out.println("utilisateurs" +utilisateurs);
            if (utilisateurs == null) {
                Utilisateurs utilisateurToSave = Utilisateurs.builder()
                        .nom(utilisateursRequest.getNom())
                        .email(utilisateursRequest.getEmail())
                        .password(utilisateursRequest.getPassword())
                        .phone(utilisateursRequest.getPhone())
                        .isActive(false)
                        .build();
                Utilisateurs utilisateurs1 = utilisateursRepository.save(utilisateurToSave);
                System.out.println("utilsateursbis" +utilisateurToSave);
                if (utilisateurs1.getId() != null) {
                    UtilisateursResponse utilisateursResponse = UtilisateursResponse.builder()
                            .id(utilisateurs1.getId())
                            .nom(utilisateurs1.getNom())
                            .email(utilisateurs1.getEmail())
                            .password(utilisateurs1.getPassword())
                            .phone(utilisateurs1.getPhone())
                            .isActive(utilisateurs1.getIsActive())
                            .build();
                    return new ResponseEntity<>(utilisateursResponse, HttpStatus.CREATED);
                }
            }else {
                throw new UtilisateursBadRequestException("this user is already created");

            }
        }
        throw new UtilisateursBadRequestException("error to save user");

    }
    public ResponseEntity<UtilisateursResponse> update(UtilisateursRequest utilisateursRequest){
        Utilisateurs utilisateurs =utilisateursRepository.findByEmail(utilisateursRequest.getEmail());
        if(utilisateurs !=null){
            Utilisateurs utilisateursToSave = Utilisateurs.builder()
                    .nom(utilisateursRequest.getNom())
                    .email(utilisateursRequest.getEmail())
                    .password(utilisateursRequest.getPassword())
                    .phone(utilisateursRequest.getPhone())
                    .isActive(utilisateursRequest.getIsActive())
                    .build();
            Utilisateurs util = utilisateursRepository.save(utilisateursToSave);
            if(util.getId()!=null){
                UtilisateursResponse utilisateursResponse = UtilisateursResponse.builder()
                        .id(util.getId())
                        .nom(util.getNom())
                        .email(util.getEmail())
                        .phone(util.getPhone())
                        .password(util.getPassword())
                        .isActive(util.getIsActive())
                        .build();
                return new ResponseEntity<>(utilisateursResponse ,HttpStatus.OK);
            }else
                throw new UtilisateursBadRequestException("error to save the user wallet");

            }
        throw new UtilisateursBadRequestException("this user already created");

        }
        public ResponseEntity<UtilisateursResponse> activated(Long id){
        Utilisateurs utilisateurs= utilisateursRepository.findById(id).orElseThrow(() -> new UtilisateursNotFoundException(id));
        if(utilisateurs.getId()!=null){
            if(utilisateurs.getIsActive()==false){
                utilisateurs.setIsActive(true);
            }
            Utilisateurs utilisateurs1=utilisateursRepository.save(utilisateurs);
            UtilisateursResponse utilisateursResponse= UtilisateursResponse.builder()
                    .id(utilisateurs1.getId())
                    .nom(utilisateurs1.getNom())
                    .email(utilisateurs1.getEmail())
                    .password(utilisateurs1.getPassword())
                    .phone(utilisateurs1.getPhone())
                    .isActive(utilisateurs1.getIsActive())
                    .build();
            return new ResponseEntity<>(utilisateursResponse,HttpStatus.OK);
        }else{
            throw new UtilisateursNotFoundException(id);
        }
        }
    }




