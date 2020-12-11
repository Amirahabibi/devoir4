package com.amira.etudiant.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.amira.etudiant.entities.Etudiant;
import com.amira.etudiant.entities.Inscription;

public interface EtudiantService {
	Etudiant saveEtudiant(Etudiant etudiant);
	Etudiant updateEtudiant(Etudiant e);
	void deleteEtudiant(Etudiant e);
	 void deleteEtudiantById(Long id);
	 Etudiant getEtudiant(Long id);
	List<Etudiant> getAllEtudiants();
	Page<Etudiant> getAllEtudiantsParPage(int page, int size);
	
	List<Etudiant> findByNomEtudiant(String libelle);
	List<Etudiant> findByNomContains(String libelle);
	List<Etudiant> findByNomPrenom (String libelle, Double prix);
	List<Etudiant> findByInscription (Inscription inscription);
	List<Etudiant> findByInscriptionIdInscri(Long id);
	List<Etudiant> findByOrderByNomEtudiantAsc();
	List<Etudiant> trierEtudiantsNomPrenom();
	List<Etudiant> findByNomPrenom(String NomEtudiant, String PrenomEtudiant);




}