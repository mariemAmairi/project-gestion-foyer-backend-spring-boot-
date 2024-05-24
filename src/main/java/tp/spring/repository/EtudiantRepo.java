package tp.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tp.spring.entities.Etudiant;
@Repository
public interface EtudiantRepo extends JpaRepository<Etudiant,Long>{

}
