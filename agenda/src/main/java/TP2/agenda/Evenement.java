package TP2.agenda;

import java.util.Date;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;


@Entity
public class Evenement {
	private Long id;
	private String nomEvenement;
	private String description;
	private Date dateEvenement;
	
	@ManyToOne
	(cascade=CascadeType.ALL)
	Agenda agendas;
	
	 public Evenement() {
		super();
	}
	
	 public Evenement(String nomEvenement, String description, Date dateEvenement) {
		super();
		this.nomEvenement = nomEvenement;
		this.description = description;
		this.dateEvenement = dateEvenement;
	}
	 
	 

	 public Evenement(String nomEvenement, String description, Date dateEvenement, Agenda agendas) {
		super();
		this.nomEvenement = nomEvenement;
		this.description = description;
		this.dateEvenement = dateEvenement;
		this.agendas = agendas;
	}

	 @Id
	 @GeneratedValue
	 public Long getId() {
	 return id;
	 }

	 public void setid(long id) {
	 this.id = id;
	 }
	 
	public String getNomEvenement() {
		return nomEvenement;
	}
	public void setNomEvenement(String nomEvenement) {
		this.nomEvenement = nomEvenement;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDateEvenement() {
		return dateEvenement;
	}
	public void setDateEvenement(Date dateEvenement) {
		this.dateEvenement = dateEvenement;
	}
	
	@ManyToOne
	public Agenda getAgendas() {
		return agendas;
	}

	public void setAgendas(Agenda agendas) {
		this.agendas = agendas;
	}
}
