package tp.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tp.spring.entities.Universite;
@Repository
public interface UniversiteRepo extends JpaRepository<Universite, Long>{

}
