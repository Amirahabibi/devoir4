package com.amira.etudiant.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.amira.etudiant.entities.Etudiant;
import com.amira.etudiant.entities.Inscription;

public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {
List<Etudiant> findByNomEtudiant(String NomEtudiant );
List<Etudiant> findByNomEtudiantContains(String NomEtudiant);
List<Etudiant> findByNomPrenom (String NomEtudiant, String PrenomEtudiant	);
@Query("select e from  Etudiant a where e.Nom like %:Nom and e.cin > :cin")
List<Etudiant> findByNomPrenom  (@Param("NomEtudiant") String NomEtudiant,@Param("PrenomEtudiant ") Double prix);
@Query("select e from Etudiant e where e.etudiant = ?1")
List<Etudiant> findByInscription (Inscription inscription);
List<Etudiant> findByInscriptionIdInscri(Long id);
List<Etudiant> findByOrderByNomEtudiantAsc();
@Query("select e from Etudiant e order by e.NomEtudiant ASC, e.cin DESC")
List<Etudiant> trierEtudiantsNomPrenom ();

}
