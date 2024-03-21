package TP2.agenda;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Agenda {

	private long id;
	private String nom;
	@ManyToOne
	(cascade=CascadeType.ALL)
	Personne personnes;
	 
	public Agenda() {
		super();
    }
		 
	public Agenda(String nom) {
		super();
		this.nom = nom;
	}
		 
	public Agenda(String nom, Personne personnes) {
		super();
		this.nom = nom;
		this.personnes = personnes;
		}
	
	@Id
	@GeneratedValue
	public long getId() {
	    return id;
	}

	public void setid(long id) {
	    this.id = id;
	}
	 
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	@ManyToOne
	public Personne getpersonnes() {
		return personnes;
	}

	public void setPersonnes(Personne personnes) {
		this.personnes = personnes;
	}
}
