package it.airports.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import it.airports.model.Metar;
import it.airports.repository.MetarRepository;

@RestController
@RequestMapping("/airport")
public class AirportRestController {
	

	
	@Autowired
	MetarRepository metarService;
	
  	@GetMapping("/metar/{icaoCode}")
  	public Metar getMetar(@PathVariable String icaoCode) {

  	    return metarService.findTopByIcaoCodeOrderByTimeDesc(icaoCode);
  	    
  	    
  	}

	@PostMapping("/{icaoCode}/metar")
	public Metar add(@RequestBody Metar met) {
		if(met.getTime()!=null) {
		return metarService.save(met);
		}
		else
	    return null;
	}
   	
 

}
