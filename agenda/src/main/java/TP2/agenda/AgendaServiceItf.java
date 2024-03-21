package TP2.agenda;

public interface AgendaServiceItf {
	void ajoutAgenda(String nom);
	void ajoutAgenda(String nom, Personne personne);
	Iterable<Agenda> getAllAgendas();
	Iterable<Agenda> getAgendasByUser(Personne personne);
	Agenda getAgendaById(Long aId);
}
