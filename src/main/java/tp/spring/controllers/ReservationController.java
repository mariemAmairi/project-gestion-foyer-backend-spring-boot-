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

import tp.spring.entities.Reservation;
import tp.spring.services.ReservationService;

@RestController
public class ReservationController {
	@Autowired
    private ReservationService reservationService;
 @PostMapping("/addreservation")
    public Reservation createReservation(@RequestBody Reservation reservation) {
        return reservationService.createReservation(reservation);
    }
 @GetMapping("/reservationList")
    public List<Reservation> getAllReservations() {
        return reservationService.getAllReservation();
    }
 @GetMapping("/reservationById/{id}")
    public ResponseEntity<Reservation> getReservationById(@PathVariable(value = "id") String id) {
        Optional<Reservation> reservation = reservationService.getReservationById(id);
        if (reservation.isPresent()) {
            return new ResponseEntity<>(reservation.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
 @PutMapping("/updateReservation{id}")
    public ResponseEntity<Reservation> updateReservation(@PathVariable(value = "id") String id, @RequestBody Reservation reservation) {
        Optional<Reservation> existingReservation = reservationService.getReservationById(id);
        if (existingReservation.isPresent()) {
            Reservation updatedReservation = existingReservation.get();
            updatedReservation.setAnneeUniversitaire(reservation.getAnneeUniversitaire());
            updatedReservation.setEstValide(reservation.isEstValide());
            
            return new ResponseEntity<>(reservationService.updateReservation(updatedReservation), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
 @DeleteMapping("/deleteReservation/{id}")
    public ResponseEntity<Object> deleteReservationById(@PathVariable(value = "id") String id) {
        Optional<Reservation> existingReservation = reservationService.getReservationById(id);
        if (existingReservation.isPresent()) {
            reservationService.deleteReservationById(id);
            return ResponseEntity.ok().body("{\"message\": \"reservation deleted successfully\"}");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"message\": \"reservation was not found\"}");
        }
    }
}
