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
@RequestMapping("/subscriptions")
public class SubscriptionRestController {
	
	@Autowired
	SubscriptionsRepository subsService;
	
	@Autowired
	MetarRepository metarService;
	
	@GetMapping("/airports")
	 public Iterable<Subscriptions> getAirports() {
		
		 return subsService.findAll();
	 }
	
	@GetMapping("/airport/{icaoCode}")
	 public Subscriptions getAirport(@PathVariable String icaoCode) {
		
		 return subsService.findById(icaoCode).get();
	 }
	
	@PostMapping("/add")
	public Subscriptions add(@RequestBody Subscriptions air) {
		return subsService.save(air);
		
	}
	


   	@DeleteMapping(value ="/delete/{icaoCode}")
	  public void delete(@PathVariable String icaoCode) {
   		subsService.deleteById(icaoCode);
	 }
   	
   	
 

}
