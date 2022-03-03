package it.airports.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.airports.model.Subscriptions;
import it.airports.repository.SubscriptionsRepository;

import it.airports.model.Metar;
import it.airports.repository.MetarRepository;

@RestController
@RequestMapping("/airport")
public class AirportRestController {
	

	
	@Autowired
	MetarRepository metarService;
	
  	@GetMapping("/airport/{icaoCode}/metar")
  	public Iterable<Metar> getMetar() {

  		return metarService.findAll();
  	}

	@PostMapping("/airport/{icaoCode}/metar")
	public Metar add(@RequestBody Metar met) {
		
		return metarService.save(met);
	
	}
   	
 

}
