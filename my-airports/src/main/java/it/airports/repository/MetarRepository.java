package it.airports.repository;

import org.springframework.data.repository.CrudRepository;

import it.airports.model.Metar;


public interface MetarRepository extends CrudRepository<Metar, String> {

}
