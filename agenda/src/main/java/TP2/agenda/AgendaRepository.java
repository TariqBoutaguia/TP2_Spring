package TP2.agenda;

import org.springframework.data.repository.CrudRepository;

public interface AgendaRepository extends CrudRepository<Agenda, Long>{
	Iterable<Agenda> findByPersonnes(Personne personne);
}
