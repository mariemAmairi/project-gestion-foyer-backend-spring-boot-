package tp.spring.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tp.spring.entities.Bloc;
import tp.spring.services.BlocService;

@RestController
public class BlocController {
	 @Autowired
	    private BlocService blocService;
	 @PostMapping("/addBloc")
	    public Bloc createBloc(@RequestBody Bloc bloc) {
	        return blocService.createBloc(bloc);
	    }
	 @GetMapping("/blocList")
	    public List<Bloc> getAllBlocs() {
	        return blocService.getAllBlocss();
	    }
	 @GetMapping("/blocById/{id}")
	    public ResponseEntity<Bloc> getBlocById(@PathVariable(value = "id") Long id) {
	        Optional<Bloc> bloc = blocService.getBlocById(id);
	        if (bloc.isPresent()) {
	            return new ResponseEntity<>(bloc.get(), HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }
	 @PutMapping("/updateBloc/{id}")
	    public ResponseEntity<Bloc> updateBloc(@PathVariable(value = "id") Long id, @RequestBody Bloc bloc) {
	        Optional<Bloc> existingBloc = blocService.getBlocById(id);
	        if (existingBloc.isPresent()) {
	            Bloc updatedBloc = existingBloc.get();
	            updatedBloc.setNomBloc(bloc.getNomBloc());
	            updatedBloc.setCapaciteBloc(bloc.getCapaciteBloc());
	            
	            return new ResponseEntity<>(blocService.updateBloc(updatedBloc), HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }
	 @DeleteMapping("/deleteBloc/{id}")
	    public ResponseEntity<Object> deleteBlocById(@PathVariable(value = "id") Long id) {
	        Optional<Bloc> existingBloc = blocService.getBlocById(id);
	        if (existingBloc.isPresent()) {
	            blocService.deleteBlocById(id);
	            return ResponseEntity.ok().body("{\"message\": \"Bloc deleted successfully\"}");
	        } else {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"message\": \"Bloc was not found\"}");
	        }
	    }
}
