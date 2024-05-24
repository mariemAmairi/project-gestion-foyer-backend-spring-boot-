package tp.spring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import tp.spring.entities.Reservation;
import tp.spring.repository.ReservationRepo;

@Service
public class ReservationService {
	@Autowired
    private ReservationRepo repo;
	    
	    public Reservation createReservation(Reservation reservation) {
	        return repo.save(reservation);
	    }
	    
	    public List<Reservation> getAllReservation() {
	        return repo.findAll();
	    }
	    
	    public Optional<Reservation> getReservationById(String id) {
	        return repo.findById(id);
	    }
	    
	    public Reservation updateReservation(Reservation reservation) {
	        return repo.save(reservation);
	    }
	    
	    public void deleteReservationById(String id) {
	        repo.deleteById(id);
	    }
}
