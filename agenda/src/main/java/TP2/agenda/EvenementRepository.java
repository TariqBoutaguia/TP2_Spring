package TP2.agenda;

import org.springframework.data.repository.CrudRepository;



public interface EvenementRepository extends CrudRepository<Evenement, Long>{
	Iterable<Evenement> findByAgendas(Agenda agenda);
}
