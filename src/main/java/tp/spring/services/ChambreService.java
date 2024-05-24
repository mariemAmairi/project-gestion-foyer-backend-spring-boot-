package tp.spring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tp.spring.entities.Chambre;
import tp.spring.repository.ChambreRepo;

@Service
public class ChambreService {
	@Autowired
    private ChambreRepo repo;
	    
	    public Chambre createChambre(Chambre chambre) {
	        return repo.save(chambre);
	    }
	    
	    public List<Chambre> getAllChambres() {
	        return repo.findAll();
	    }
	    
	    public Optional<Chambre> getChambreById(Long id) {
	        return repo.findById(id);
	    }
	    
	    public Chambre updateChambre(Chambre chambre) {
	        return repo.save(chambre);
	    }
	    
	    public void deleteChambreById(Long id) {
	        repo.deleteById(id);
	    }
}
