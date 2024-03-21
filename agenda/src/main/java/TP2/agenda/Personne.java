package TP2.agenda;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Personne{
	   private String email;
	   private String pwd;
       private String nom;
       private String prenom;
       
       public Personne() {
    	   nom = "";
    	   prenom = "";
		    
       }
       
       public Personne(String email, String pwd, String nom, String prenom) {
    	   //super();
    	    this.email = email;
		    this.pwd = pwd;
		    this.nom = nom;
		    this.prenom = prenom;
       }
       
       public String getPwd() {
    	   return pwd;
       }
       public void setPwd(String pwd) {
    	   this.pwd= pwd;
       }
       
       public String getNom() {
    	   return nom;
       }
       public String getPrenom() {
    	   return prenom;
       }
       
       public void setNom(String nom) {
    	   this.nom = nom;
       }
       
       public void setPrenom(String prenom) {
    	   this.prenom= prenom;
       }
       
       @Id

       public String getEmail() {
    	   return email;
       }
       public void setEmail(String email) {
    	   this.email = email;
       }
}
