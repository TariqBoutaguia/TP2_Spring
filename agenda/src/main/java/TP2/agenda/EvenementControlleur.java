package TP2.agenda;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;



import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class EvenementControlleur {
	@Autowired
    private EvenementServiceItf service;
	@Autowired
    private AgendaServiceItf serviceAgenda;
	
	@GetMapping("/evenements/liste/{agendaId}")
	public String voirMesevenement(@PathVariable("agendaId") Long agendaId, Model model, HttpSession session) {
		if(session.getAttribute("personne") == null) {
			return "redirect:/home";
		} else {
		    Agenda agenda = serviceAgenda.getAgendaById(agendaId); 
	        Iterable<Evenement> evenements = service.getEvenementByAgendas(agenda);
	        model.addAttribute("evenements", evenements);
	        model.addAttribute("agendaId", agendaId);
	        return "listeEvenement";
		}
	}

	@GetMapping("/evenements/new/{agendaId}")
	public String MesAgendaNouveau(@PathVariable("agendaId") Long agendaId,Model model, HttpSession session) {
		if(session.getAttribute("personne") == null) {
			return "redirect:/home";
		} else {
		model.addAttribute("agendaId", agendaId);
	    return "evenement";
		}
    }
	
	@PostMapping("/evenements/new/{agendaId}")
	public String addEvenement(@PathVariable("agendaId") Long agendaId,@RequestParam String nomEvenement,@RequestParam String description, @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateEvenement, HttpSession session) {
		if(session.getAttribute("personne") == null) {
			return "redirect:/home";
		} else {
		    Agenda agenda = serviceAgenda.getAgendaById(agendaId);
            service.ajoutEvenement(nomEvenement, description, dateEvenement, agenda);
            return "redirect:/evenements/liste/"+ agendaId;
		}
    }
	
	@PostMapping("/delete/{evenementId}/{agendaId}")
    public String deleteEvenement(@PathVariable("evenementId") Long evenementId,@PathVariable("agendaId") Long agendaId, HttpSession session) {
		if(session.getAttribute("personne") == null) {
			return "redirect:/home";
		} else {
            service.deleteEvenementById(evenementId);
            return "redirect:/evenements/liste/"+ agendaId; 
		}
    }
	
	@GetMapping("/imprimer/{agendaId}")
    public String imprimer(@PathVariable("agendaId") Long agendaId, HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		if(session.getAttribute("personne") == null) {
			return "redirect:/home";
		} else {
	       String personne = (String) session.getAttribute("nom");
	       Agenda agenda = serviceAgenda.getAgendaById(agendaId); 
	       String nomAgenda = agenda.getNom();
	       Iterable<Evenement> evenements = service.getEvenementByAgendas(agenda);
	       model.addAttribute("evenements", evenements);
	       model.addAttribute("personne", personne);
	       model.addAttribute("nom_agenda", nomAgenda);
           return "Imprimer"; 
		}
    }
}
