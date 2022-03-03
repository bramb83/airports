package it.airports.repository;

import org.springframework.data.repository.CrudRepository;

import it.airports.model.Subscriptions;


public interface SubscriptionsRepository extends CrudRepository<Subscriptions, String> {

}
