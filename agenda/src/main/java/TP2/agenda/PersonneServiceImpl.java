package TP2.agenda;

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
    Iterable<Personne> Personnes = findByEmail(email);
    boolean valid = false;
    for(Personne Personne: Personnes) {
    valid = (Personne.getPwd().equals(password));
    }
    return valid;
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

}
	
	
	
	

