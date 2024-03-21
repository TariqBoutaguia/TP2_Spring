package TP2.agenda;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class EvenementServiceImpl implements EvenementServiceItf {
	@Autowired
    private EvenementRepository repo;
	

	@Override
	public Iterable<Evenement> getEvenementByAgendas(Agenda agenda) {
		// TODO Auto-generated method stub
		return repo.findByAgendas(agenda);
    }

	@Override
	public void ajoutEvenement(String nomEvenement, String description, Date dateEvenement, Agenda agenda) {
		// TODO Auto-generated method stub
		repo.save(new Evenement(nomEvenement, description, dateEvenement, agenda));
		
	}

	@Override
    public void deleteEvenementById(Long evenementId) {
        repo.deleteById(evenementId);
    }
}
