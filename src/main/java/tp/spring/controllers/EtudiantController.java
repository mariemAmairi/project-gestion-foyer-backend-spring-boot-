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


import tp.spring.entities.Etudiant;

import tp.spring.services.EtudiantService;

@RestController
public class EtudiantController {
	 @Autowired
	    private EtudiantService etudiantService;
	 @PostMapping("/addEtudiant")
	    public Etudiant createEtudiant(@RequestBody Etudiant etudiant) {
	        return etudiantService.createEtudiant(etudiant);
	    }
	 @GetMapping("/etudiantList")
	    public List<Etudiant> getAllEtudiants() {
	        return etudiantService.getAllEtudiants();
	    }
	 @GetMapping("/etudiantById/{id}")
	    public ResponseEntity<Etudiant> getEtudiantById(@PathVariable(value = "id") Long id) {
	        Optional<Etudiant> etudiant = etudiantService.getEtudiantById(id);
	        if (etudiant.isPresent()) {
	            return new ResponseEntity<>(etudiant.get(), HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }
	 @PutMapping("/updateEtudiant/{id}")
	    public ResponseEntity<Etudiant> updateEtudiant(@PathVariable(value = "id") Long id, @RequestBody Etudiant etudiant) {
	        Optional<Etudiant> existingEtudiant = etudiantService.getEtudiantById(id);
	        if (existingEtudiant.isPresent()) {
	            Etudiant updatedEtudiant = existingEtudiant.get();
	            updatedEtudiant.setName(etudiant.getName());
	            updatedEtudiant.setPrenom(etudiant.getPrenom());
	            updatedEtudiant.setCin(etudiant.getCin());
	            updatedEtudiant.setDateNaissance(etudiant.getDateNaissance());
	            updatedEtudiant.setEcole(etudiant.getEcole());
	            
	            return new ResponseEntity<>(etudiantService.updateEtudiant(updatedEtudiant), HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }
	 @DeleteMapping("/deleteEtudiant/{id}")
	    public ResponseEntity<Object> deleteEtudiantById(@PathVariable(value = "id") Long id) {
	        Optional<Etudiant> existingEtudiant = etudiantService.getEtudiantById(id);
	        if (existingEtudiant.isPresent()) {
	            etudiantService.deleteEtudiantById(id);
	            return ResponseEntity.ok().body("{\"message\": \"etudiant deleted successfully\"}");
	        } else {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"message\": \"etudiant was not found\"}");
	        }
	    }
}
