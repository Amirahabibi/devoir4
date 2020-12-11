package com.amira.etudiant;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.amira.etudiant.entities.Etudiant;
import com.amira.etudiant.entities.Inscription;
import com.amira.etudiant.repos.EtudiantRepository;
import com.amira.etudiant.service.EtudiantService;



@SpringBootTest
class EtudiantApplicationTests {

	@Autowired
	private EtudiantRepository etudiantRepository;
	@Autowired
	private EtudiantService etudiantService;
	@Test
	public void testCreateProduit() {
	Etudiant etudiant = new Etudiant("Telephone","rouge","samsung",1000,new Date());
	etudiantRepository.save(etudiant);
}
	 @Test
	 public void testFindArticle()
	 {
	 Etudiant etudiant = etudiantRepository.findById(1L).get();
	 System.out.println(etudiant);
	 }
	 @Test
	 public void testUpdateArticle()
	 {
	 Etudiant a= etudiantRepository.findById(1L).get();
	 a.setPrixUnitaire(500);
	 etudiantRepository.save(a);
	 System.out.println(a);
	 }
	 @Test
	 public void testDeleteArticle() {
		 etudiantRepository.deleteById(1L);
	 }
	 @Test
	 public void testListerTousArticle()
	 {
	 List<Etudiant> etudiant = etudiantRepository.findAll();
	 for (Etudiant a : etudiant)
	 {
	 System.out.println(a);
	 }
}
	 @Test
	 public void testFindByLibelleContains()
	 {
	 Page<Etudiant> a = etudiantService.getAllArticlesParPage(0,2);
	 System.out.println(a.getSize());
	 System.out.println(a.getTotalElements());
	 System.out.println(a.getTotalPages());
	 a.getContent().forEach(p -> {System.out.println(p.toString());
	  });
	
	 }
	 @Test
	 public void testFindArticleByNom()
	 {
	 List<Etudiant> arts = etudiantRepository.findByLibelle("PC");
	 for(Etudiant a:arts) {
	 System.out.println(a);}
	 }
	 @Test
	 public void testFindArticleByNomContains()
	 {
	 List<Etudiant> arts = etudiantRepository.findByLibelleContains("e");
	 for(Etudiant a:arts) {
	 System.out.println(a);}
	 }
	 @Test
	 public void testfindByLibellePrix()
	 {
	 List<Etudiant> arts = etudiantRepository.findByLibellePrix("chargeurPortable", 40.0);
	 for (Etudiant a : arts)
	 {
	 System.out.println(a);
	 }
	 }
	 @Test
		public void testfindByClient()
		{
		Inscription cl = new Inscription();
		cl.setIdClient(1L);
		List<Etudiant> arts = etudiantRepository.findByClient(cl);
		for (Etudiant a : arts)
		{
		System.out.println(a);
		}
}
	 @Test
	 public void findByClientIdClient()
	 {
	 List<Etudiant> arts = etudiantRepository.findByClientIdClient(1L);
	 for (Etudiant a : arts)
	 {
	 System.out.println(a);
	 }
	  }
	 @Test
	 public void testfindByOrderByLibelleAsc()
	 {
	 List<Etudiant> arts =
	 etudiantRepository.findByOrderByLibelleAsc();
	 for (Etudiant a : arts)
	 {
	 System.out.println(a);
	 }
	 }
	 @Test
	 public void testTrierArticlesLibellePrix()
	 {
	 List<Etudiant> arts = etudiantRepository.trierArticlesLibellesPrix();
	 for (Etudiant a : arts)
	 {
	 System.out.println(a);
	 }
	 }

}
