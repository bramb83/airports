package it.airports.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import it.airports.model.Subscriptions;


public interface SubscriptionsRepository extends JpaRepository<Subscriptions, String> {

	Subscriptions save(String icaoCode);

}
