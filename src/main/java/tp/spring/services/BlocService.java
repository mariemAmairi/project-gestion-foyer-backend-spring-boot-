package tp.spring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tp.spring.entities.Bloc;
import tp.spring.repository.BlocRepo;

@Service
public class BlocService {
	@Autowired
    private BlocRepo repo;
	    
	    public Bloc createBloc(Bloc bloc) {
	        return repo.save(bloc);
	    }
	    
	    public List<Bloc> getAllBlocss() {
	        return repo.findAll();
	    }
	    
	    public Optional<Bloc> getBlocById(Long id) {
	        return repo.findById(id);
	    }
	    
	    public Bloc updateBloc(Bloc bloc) {
	        return repo.save(bloc);
	    }
	    
	    public void deleteBlocById(Long id) {
	        repo.deleteById(id);
	    }
}
