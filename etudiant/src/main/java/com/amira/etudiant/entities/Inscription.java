package com.amira.etudiant.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Inscription {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEtudiant;
	private Data dateinscrit;
	@OneToMany(mappedBy="inscription")
	private List<Etudiant> etudiants;
	
	public Inscription() {
		super();
	
	}
	public Inscription(Data dateinscrit, List<Etudiant> etudiants) {
		super();
		this.dateinscrit = dateinscrit;
		this.etudiants = etudiants;
	}
	public Long getIdEtudiant() {
		return idEtudiant;
	}
	public void setIdEtudiant(Long idEtudiant) {
		this.idEtudiant = idEtudiant;
	}
	public Data getDateinscrit() {
		return dateinscrit;
	}
	public void setDateinscrit(Data dateinscrit) {
		this.dateinscrit = dateinscrit;
	}
	public List<Etudiant> getEtudiants() {
		return etudiants;
	}
	public void setEtudiants(List<Etudiant> etudiants) {
		this.etudiants = etudiants;
	}
	@Override
	public String toString() {
		return "Inscription [idEtudiant=" + idEtudiant + ", dateinscrit=" + dateinscrit + ", etudiants=" + etudiants
				+ "]";
	}
	
	
	
}
