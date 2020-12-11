package com.amira.etudiant.Controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.amira.etudiant.entities.Etudiant;
import com.amira.etudiant.service.EtudiantService;

@Controller
public class EtudiantController {

	@Autowired
	EtudiantService etudiantService;
	@RequestMapping("/showCreate")
	public String showCreate()
	{
	return "createEtudiant";
	}
	@RequestMapping("/saveEtudiant")
	public String saveArticle(@ModelAttribute("etudiant") Etudiant etudiant,
	                          @RequestParam("date") String date,
	                          ModelMap modelMap) throws ParseException
	                          
	{
	
	SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
	 Date dateInscrit = dateformat.parse(String.valueOf(date));
	 etudiant.setDateInscrit(dateInscrit);

	Etudiant saveEtudiant = etudiantService.saveEtudiant(etudiant);
	String msg ="Etudiant enregistré avec Id "+saveEtudiant. getIdEtudiant();
	modelMap.addAttribute("msg", msg);
	return "createEtudiant";

}
	@RequestMapping("/ListeEtudiants")
	public String listeEtudiant(ModelMap modelMap,
	@RequestParam (name="page",defaultValue = "0") int page,
	@RequestParam (name="size", defaultValue = "3") int size)
	{ 
		
		Page<Etudiant> e = etudiantService.getAllEtudiantsParPage(page, size);
		modelMap.addAttribute("etudiant", e);
		 modelMap.addAttribute("pages", new int[e.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		modelMap.addAttribute("size", size);

	return "listeEtudiants";
	}
	@RequestMapping("/supprimerEtudiant")
	public String supprimerArticle(@RequestParam("id") Long id,
	                     ModelMap modelMap,
	                     @RequestParam (name="page",defaultValue = "0") int page,
	                     @RequestParam (name="size", defaultValue = "2") int size)
	{
	etudiantService.deleteEtudiantById(id);
	Page<Etudiant> e = etudiantService.getAllEtudiantsParPage(page,size);
			modelMap.addAttribute("Etudiant", e);
			modelMap.addAttribute("pages", new int[e.getTotalPages()]);
			modelMap.addAttribute("currentPage", page);
			modelMap.addAttribute("size", size);
	return "listeEtudiants";
	}
	@RequestMapping("/modifierEtudiant")
	public String editerEtudiant(@RequestParam("id") Long id,ModelMap modelMap)
	{
	Etudiant e= etudiantService.getEtudiant(id);
	modelMap.addAttribute("etudiant", e);
	return "EditerEtudiant";
	}
	@RequestMapping("/updateEtudiant")
	public String updateEtudiant(@ModelAttribute("etudiant") Etudiant etudiant,
	@RequestParam("date") String date,
	ModelMap modelMap) throws ParseException
	{
	//conversion de la date
	 SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
	 Date dateInscrit= dateformat.parse(String.valueOf(date));
	 etudiant.setDateInscrit(dateInscrit);

	 etudiantService.updateEtudiant(etudiant);
	 List<Etudiant> e = etudiantService.getAllEtudiants();
	 modelMap.addAttribute("etudiants", e);
	return "listeEtudiants";
}
}
