package TP2.agenda;

import java.util.Date;


public interface EvenementServiceItf {
	Iterable<Evenement> getEvenementByAgendas(Agenda agenda);

	void ajoutEvenement(String nomEvenement, String description, Date dateEvenement, Agenda agenda);

	void deleteEvenementById(Long evenementId);
}
