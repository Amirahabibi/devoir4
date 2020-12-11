package com.amira.etudiant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.amira.etudiant.entities.Etudiant;
import com.amira.etudiant.entities.Inscription;
import com.amira.etudiant.repos.EtudiantRepository;
@Service
public class EtudiantServiceImpl implements EtudiantService{
@Autowired
	EtudiantRepository etudiantRepository;

@Override
public Etudiant saveEtudiant(Etudiant etudiant) {
	return etudiantRepository.save(etudiant);
}

@Override
public Etudiant updateEtudiant(Etudiant e) {
	return etudiantRepository.save(e);
}

@Override
public void deleteEtudiant(Etudiant e) {
	etudiantRepository.delete(e);
	
}

@Override
public void deleteEtudiantById(Long id) {
	etudiantRepository.deleteById(id)
	
}

@Override
public Etudiant getEtudiant(Long id) {
	return etudiantRepository.findById(id).get();
}

@Override
public List<Etudiant> getAllEtudiants() {
	return etudiantRepository.findAll();
}

@Override
public Page<Etudiant> getAllEtudiantsParPage(int page, int size) {
	return etudiantRepository.findAll(PageRequest.of(page, size));
}

@Override
public List<Etudiant> findByNomEtudiant(String NomEtudiant) {
	return etudiantRepository.findByNomEtudiant(NomEtudiant);
}

@Override
public List<Etudiant> findByNomContains(String NomEtudiant) {
	return etudiantRepository.findByNomEtudiantContains(NomEtudiant);
}

@Override
public List<Etudiant> findByNomPrenom(String NomEtudiant, String PrenomEtudiant) {
	
	return null;
}

@Override
public List<Etudiant> findByInscription(Inscription inscription) {
	
	return etudiantRepository.findByInscription(inscription);
}

@Override
public List<Etudiant> findByInscriptionIdInscri(Long id) {
	return etudiantRepository.findByInscriptionIdInscri(id);
}

@Override
public List<Etudiant> findByOrderByNomEtudiantAsc() {
	return etudiantRepository.findByOrderByNomEtudiantAsc();
}

@Override
public List<Etudiant> trierEtudiantsNomPrenom() {
	return etudiantRepository.trierEtudiantsNomPrenom();
}
	

}
