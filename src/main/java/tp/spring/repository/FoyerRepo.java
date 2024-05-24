package tp.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tp.spring.entities.Foyer;
@Repository
public interface FoyerRepo extends JpaRepository<Foyer, Long> {

}
