package TP2.agenda;


public interface PersonneServiceItf {
    void init();
    //void ajoutAuteur();
    Iterable<Personne> getAllPersonnes();
    
    Iterable<Personne> findByEmail(String email);
    
    void ajoutPersonne(String email, String pwd, String nom, String prenom);
    
    boolean login(String email, String password);
}
