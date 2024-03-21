package TP2.agenda;


public interface PersonneServiceItf {
    void init();
    //void ajoutPersonne();
    Iterable<Personne> getAllPersonnes();
    
    Iterable<Personne> findByEmail(String email);
    
    Iterable<Personne> getUserInfo(String email);
    
    void ajoutPersonne(String email, String pwd, String nom, String prenom);
    
    boolean login(String email, String password);
    
    Personne getPersonneByEmail(String email);
}
