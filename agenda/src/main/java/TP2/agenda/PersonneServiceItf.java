package TP2.agenda;


public interface PersonneServiceItf {
    void init();
    //void ajoutAuteur();
    Iterable<Personne> getAllPersonnes();
	   void ajoutPersonne(String email, String pwd, String nom, String prenom);
}
