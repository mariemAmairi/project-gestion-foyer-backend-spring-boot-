package tp.spring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import tp.spring.entities.Universite;
import tp.spring.repository.UniversiteRepo;

@Service
public class UniversiteService {
	@Autowired
    private UniversiteRepo repo;
	    
	    public Universite createUniversite(Universite universite) {
	        return repo.save(universite);
	    }
	    
	    public List<Universite> getAllUniversites() {
	        return repo.findAll();
	    }
	    
	    public Optional<Universite> getUniversiteById(Long id) {
	        return repo.findById(id);
	    }
	    
	    public Universite updateUniversite(Universite universite) {
	        return repo.save(universite);
	    }
	    
	    public void deleteUniversiteById(Long id) {
	        repo.deleteById(id);
	    }
}
