package TP2.agenda;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

//import demp.autheur.demo.Auteur;
//import demp.autheur.demo.AuteurServiceItf;

@Controller
//@RequestMapping("/bib")
public class PersonneControlleur {
	
	  @Autowired
	  private PersonneServiceItf service;
	  
    @GetMapping("/home")
    public String home(Model model) {
  	  return "home";
    }
    
    @PostMapping("/signin")
    public String addAuteur(@RequestParam String email, @RequestParam String pwd, @RequestParam String nom, @RequestParam String prenom) {
  	  service.ajoutPersonne(email, pwd, nom, prenom);
    return "redirect:/home";
  	  
    }
    
    

    
}
