package it.airports.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


import it.airports.model.Metar;

@EnableJpaRepositories
public interface MetarRepository extends JpaRepository<Metar, String> {

	
	Metar findTopByIcaoCodeOrderByTimeDesc(String icaoCode);
	

}
