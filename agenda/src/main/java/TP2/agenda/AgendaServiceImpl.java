package TP2.agenda;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgendaServiceImpl implements AgendaServiceItf {
	
	@Autowired
    private AgendaRepository repo;
	
	
	@Override
    public void ajoutAgenda(String nom) {
        // TODO Auto-generated method stub
        repo.save(new Agenda(nom));
    }
	
	@Override
	public void ajoutAgenda(String nom, Personne personne) {
        // TODO Auto-generated method stub
        repo.save(new Agenda(nom, personne));
    }
	
	@Override
	 public Iterable<Agenda> getAllAgendas() {
	        // TODO Auto-generated method stub
	        return repo.findAll();
	  }

	@Override
	public Iterable<Agenda> getAgendasByUser(Personne personne) {
		// TODO Auto-generated method stub
		return repo.findByPersonnes(personne);
	}

	@Override
	public Agenda getAgendaById(Long agendaId) {
		Optional<Agenda> optionalAgenda = repo.findById(agendaId);
		return optionalAgenda.orElse(null);
	}
}
