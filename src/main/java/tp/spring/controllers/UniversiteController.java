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


import tp.spring.entities.Universite;

import tp.spring.services.UniversiteService;

@RestController
public class UniversiteController {
	@Autowired
    private UniversiteService universiteService;
 @PostMapping("/addUniversite")
    public Universite createUniversite(@RequestBody Universite universite) {
        return universiteService.createUniversite(universite);
    }
 @GetMapping("/universiteList")
    public List<Universite> getAllUniversites() {
        return universiteService.getAllUniversites();
    }
 @GetMapping("/UniversiteById/{id}")
    public ResponseEntity<Universite> getUniversiteById(@PathVariable(value = "id") Long id) {
        Optional<Universite> universite = universiteService.getUniversiteById(id);
        if (universite.isPresent()) {
            return new ResponseEntity<>(universite.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
 @PutMapping("/updateUniversite{id}")
    public ResponseEntity<Universite> updateUniversite(@PathVariable(value = "id") Long id, @RequestBody Universite universite) {
        Optional<Universite> existingUniversite = universiteService.getUniversiteById(id);
        if (existingUniversite.isPresent()) {
            Universite updatedUniversite = existingUniversite.get();
            updatedUniversite.setNomUniversite(universite.getNomUniversite());
            updatedUniversite.setAdresse(universite.getAdresse());
            
            return new ResponseEntity<>(universiteService.updateUniversite(updatedUniversite), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
 @DeleteMapping("/deleteUniversite/{id}")
    public ResponseEntity<Object> deleteUniversiteById(@PathVariable(value = "id") Long id) {
        Optional<Universite> existingUniversite = universiteService.getUniversiteById(id);
        if (existingUniversite.isPresent()) {
            universiteService.deleteUniversiteById(id);
            return ResponseEntity.ok().body("{\"message\": \"universite deleted successfully\"}");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"message\": \"universite was not found\"}");
        }
    }
}
