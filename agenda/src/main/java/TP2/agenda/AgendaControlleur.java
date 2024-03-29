package TP2.agenda;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;


@Controller
public class AgendaControlleur {
     
	@Autowired
    private AgendaServiceItf service;
	@Autowired
	private PersonneServiceItf serviceRegister;
    
	@GetMapping("/liste")
	public String home(Model model, HttpSession session) {
		if(session.getAttribute("personne") == null) {
			return "redirect:/home";
		} else {
            Iterable<Agenda> agendas = service.getAllAgendas();
            model.addAttribute("agendas", agendas);
            return "liste";
		}
    }
	
	@PostMapping("/createAgenda")
    public String addAgenda(@RequestParam String nom, HttpSession session) {
		if(session.getAttribute("personne") == null) {
			return "redirect:/home";
		} else {
            service.ajoutAgenda(nom);
            return "redirect:/liste";
		}
    }
	
	@GetMapping("/mesAgendas/liste")
	public String MesAgenda(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		if(session.getAttribute("personne") == null) {
			return "redirect:/home";
		} else {
			 Personne personne = (Personne) session.getAttribute("personne");
             Iterable<Agenda> agendas = service.getAgendasByUser(personne);
             model.addAttribute("agendas", agendas);
		     return "mesAgendas";
		}
	   
    }
	
	@GetMapping("/mesAgendas/new")
	public String MesAgendaNouveau(HttpSession session) {
		if(session.getAttribute("personne") == null) {
			return "redirect:/home";
		} else {
		    return "agenda";
		}
    }
	
	@PostMapping("/agenda/new")
	public String addAgendaUser(@RequestParam String nom, HttpServletRequest request) {
		HttpSession session = request.getSession();
		if(session.getAttribute("personne") == null) {
			return "redirect:/home";
		} else {
			String email = (String) session.getAttribute("email");
	        Personne personne = serviceRegister.getPersonneByEmail(email);
            service.ajoutAgenda(nom, personne);
            return "redirect:/mesAgendas/liste";
		} 
    }
}
