package tp.spring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import tp.spring.entities.Etudiant;

import tp.spring.repository.EtudiantRepo;

@Service
public class EtudiantService {
	@Autowired
    private EtudiantRepo repo;
	    
	    public Etudiant createEtudiant(Etudiant etudiant) {
	        return repo.save(etudiant);
	    }
	    
	    public List<Etudiant> getAllEtudiants() {
	        return repo.findAll();
	    }
	    
	    public Optional<Etudiant> getEtudiantById(Long id) {
	        return repo.findById(id);
	    }
	    
	    public Etudiant updateEtudiant(Etudiant etudiant) {
	        return repo.save(etudiant);
	    }
	    
	    public void deleteEtudiantById(Long id) {
	        repo.deleteById(id);
	    }
}
