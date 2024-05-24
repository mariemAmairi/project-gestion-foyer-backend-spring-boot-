package tp.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tp.spring.entities.Bloc;
@Repository
public interface BlocRepo extends JpaRepository<Bloc, Long> {

}
