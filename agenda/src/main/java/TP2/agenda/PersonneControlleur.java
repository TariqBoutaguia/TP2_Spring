package TP2.agenda;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@Controller
//@RequestMapping("/bib")
public class PersonneControlleur {
	
	  @Autowired
	  private PersonneServiceItf service;
	  
    /*@GetMapping("/home")
    public String home(Model model) {
  	  return "home";
    }*/
    
    @GetMapping("/home")
	public String home(Model model) {
        return "home";
    }
    
    @PostMapping("/signup")
    public String ajoutPersonne(@RequestParam String email, @RequestParam String pwd, @RequestParam String nom, @RequestParam String prenom) {
  	  service.ajoutPersonne(email, pwd, nom, prenom);
    return "redirect:/home";
    }
    
    @PostMapping("/signin")
    public String login(@RequestParam String email, @RequestParam String pwd, HttpServletRequest request, HttpServletResponse response, Model model) {
        HttpSession session = request.getSession();
        Iterable<Personne> personnes = service.getUserInfo(email);
        if(service.login(email, pwd)) {
            // Add the session attribute to the model
        	for (Personne personne : personnes) {
	            if (personne.getEmail().equals(email)) {
	            	session.setAttribute("personne", personne);
	                session.setAttribute("nom", personne.getNom());
	                session.setAttribute("prenom", personne.getPrenom());
	                session.setAttribute("email", personne.getEmail());
	                session.setAttribute("password", personne.getPwd());    
	                String nom = (String)session.getAttribute("nom");
	                model.addAttribute("nom", nom);
	                break; // No need to continue iterating  
	            }
	        }
            return "welkom";
        } else {
            return "redirect:/home";
        }
    }

    
  	  
    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        return "redirect:/home";
    }
    

    
}
