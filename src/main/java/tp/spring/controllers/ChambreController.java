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


import tp.spring.entities.Chambre;
import tp.spring.services.ChambreService;

@RestController
public class ChambreController {
	 @Autowired
	    private ChambreService chambreService;
	 @PostMapping("/addChambre")
	    public Chambre createChambre(@RequestBody Chambre chambre) {
	        return chambreService.createChambre(chambre);
	    }
	 @GetMapping("/chambreList")
	    public List<Chambre> getAllCahmbres() {
	        return chambreService.getAllChambres();
	    }
	 @GetMapping("/chambreById/{id}")
	    public ResponseEntity<Chambre> getChambreById(@PathVariable(value = "id") Long id) {
	        Optional<Chambre> chambre = chambreService.getChambreById(id);
	        if (chambre.isPresent()) {
	            return new ResponseEntity<>(chambre.get(), HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }
	 @PutMapping("/updateChambre/{id}")
	    public ResponseEntity<Chambre> updateChambre(@PathVariable(value = "id") Long id, @RequestBody Chambre chambre) {
	        Optional<Chambre> existingChambre = chambreService.getChambreById(id);
	        if (existingChambre.isPresent()) {
	            Chambre updatedChambre = existingChambre.get();
	            updatedChambre.setNumeroChambre(chambre.getNumeroChambre());
	            updatedChambre.setTypeChambre(chambre.getTypeChambre());
	            
	            return new ResponseEntity<>(chambreService.updateChambre(updatedChambre), HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }
	 @DeleteMapping("/deleteChambre/{id}")
	    public ResponseEntity<Object> deleteChambreById(@PathVariable(value = "id") Long id) {
	        Optional<Chambre> existingChambre = chambreService.getChambreById(id);
	        if (existingChambre.isPresent()) {
	            chambreService.deleteChambreById(id);
	            return ResponseEntity.ok().body("{\"message\": \"Chambre deleted successfully\"}");
	        } else {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"message\": \"Chambre was not found\"}");
	        }
	    }
}
