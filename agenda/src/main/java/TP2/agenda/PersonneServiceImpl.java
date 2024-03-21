package TP2.agenda;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonneServiceImpl implements PersonneServiceItf{
	@Autowired
	private PersonneRepository repo;
	
	@Override
	public void init() {
		repo.save(new Personne("tariq.boutaguia.etu@univ-lille.fr","tariq@2024","tariq","Boutaguia"));
		repo.save(new Personne("arthur.morgan.etu@univ-lille.fr","tariq@2024","arthur", "morgan"));
	}
	
	@Override
	public void ajoutPersonne(String email, String pwd, String nom, String prenom) {
		// TODO Auto-generated method stub
		repo.save(new Personne(email, pwd, nom, prenom));
	}
	
	@Override
	public boolean login(String email, String password) {
	    Iterable<Personne> personnes = findByEmail(email);
	    for(Personne personne : personnes) {
	        if (personne.getPwd().equals(password)) {
	            return true; // Return true if password matches
	        }
	    }
	    return false; // Return false if no matching email or password
	}

	
    @Override
	public Iterable<Personne> getAllPersonnes() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}
    
    @Override
	public Iterable<Personne> findByEmail(String email) {
		// TODO Auto-generated method stub
		return repo.findByEmail(email);
    }
    @Override
    public Iterable<Personne> getUserInfo(String email) {
    	Iterable<Personne> personne = findByEmail(email);
         return personne; 
    }
    
    @Override
    public Personne getPersonneByEmail(String email) {
        Optional<Personne> optionalPersonne = repo.findById(email);
        return optionalPersonne.orElse(null); // or throw an exception or handle it according to your application's logic
    }
}
	
	
	
	

