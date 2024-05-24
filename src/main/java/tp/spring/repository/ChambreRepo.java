package tp.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tp.spring.entities.Chambre;
@Repository
public interface ChambreRepo extends JpaRepository<Chambre, Long>{

}
