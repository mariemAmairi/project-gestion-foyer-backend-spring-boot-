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


import tp.spring.entities.Foyer;
import tp.spring.services.FoyerService;

@RestController
public class FoyerController {
	@Autowired
    private FoyerService foyerService;
 @PostMapping("/addFoyer")
    public Foyer createFoyer(@RequestBody Foyer foyer) {
        return foyerService.createFoyer(foyer);
    }
 @GetMapping("/foyerList")
    public List<Foyer> getAllFoyers() {
        return foyerService.getAllFoyers();
    }
 @GetMapping("/foyerById/{id}")
    public ResponseEntity<Foyer> getFoyerById(@PathVariable(value = "id") Long id) {
        Optional<Foyer> foyer = foyerService.getFoyerById(id);
        if (foyer.isPresent()) {
            return new ResponseEntity<>(foyer.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
 @PutMapping("/updateFoyer{id}")
    public ResponseEntity<Foyer> updateFoyer(@PathVariable(value = "id") Long id, @RequestBody Foyer foyer) {
        Optional<Foyer> existingFoyer = foyerService.getFoyerById(id);
        if (existingFoyer.isPresent()) {
            Foyer updatedFoyer = existingFoyer.get();
            updatedFoyer.setNomFoyer(foyer.getNomFoyer());
            updatedFoyer.setCapaciteFoyer(foyer.getCapaciteFoyer());
            
            return new ResponseEntity<>(foyerService.updateFoyer(updatedFoyer), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
 @DeleteMapping("/deleteFoyer/{id}")
    public ResponseEntity<Object> deleteFoyerById(@PathVariable(value = "id") Long id) {
        Optional<Foyer> existingFoyer = foyerService.getFoyerById(id);
        if (existingFoyer.isPresent()) {
            foyerService.deleteFoyerById(id);
            return ResponseEntity.ok().body("{\"message\": \"foyer deleted successfully\"}");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"message\": \"foyer was not found\"}");
        }
    }
}
