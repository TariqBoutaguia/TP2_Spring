package TP2.agenda;

import org.springframework.data.repository.CrudRepository;


public interface PersonneRepository extends CrudRepository<Personne, String> {
	Iterable<Personne> findByEmail(String email);
}
