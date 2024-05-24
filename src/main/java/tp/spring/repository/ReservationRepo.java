package tp.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tp.spring.entities.Reservation;
@Repository
public interface ReservationRepo extends JpaRepository<Reservation, String>{

}
