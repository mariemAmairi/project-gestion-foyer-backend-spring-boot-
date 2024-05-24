package tp.spring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import tp.spring.entities.Foyer;
import tp.spring.repository.FoyerRepo;

@Service
public class FoyerService {
	@Autowired
    private FoyerRepo repo;
	    
	    public Foyer createFoyer(Foyer foyer) {
	        return repo.save(foyer);
	    }
	    
	    public List<Foyer> getAllFoyers() {
	        return repo.findAll();
	    }
	    
	    public Optional<Foyer> getFoyerById(Long id) {
	        return repo.findById(id);
	    }
	    
	    public Foyer updateFoyer(Foyer foyer) {
	        return repo.save(foyer);
	    }
	    public void deleteFoyerById(Long id) {
	        repo.deleteById(id);
	    }
}
