package it.airports.controller;

import java.sql.Timestamp;

import org.apache.tomcat.util.json.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonObjectSerializer;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.util.JSONPObject;

import it.airports.model.Metar;
import it.airports.model.Subscriptions;
import it.airports.repository.MetarRepository;
import it.airports.repository.SubscriptionsRepository;



@RestController
@RequestMapping("/subscriptions")
public class SubscriptionRestController {
	
	private static final Logger log = LoggerFactory.getLogger(SubscriptionRestController.class);
	
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
   	
   	
	 public  String getIcaoCode() {
   		
   	     for (int i=0; i<subsService.findAll().size();i++) {
   	    	subsService.findAll().get(i).getIcaocode();
   	    	
		}
		return getIcaoCode();
		
	 }
   
	 @Scheduled(fixedRate = 5000)
	 private  void getMetar()
	 {
	     String uri = null;
	     String icaocode = null;
	     RestTemplate restTemplate = new RestTemplate();
	     String result=null;
	     String data=null;
	     String time=null;
	     Metar metar = new Metar();
	   
	     
	     for (int i=0; i<subsService.findAll().size();i++) {
	   	    icaocode =subsService.findAll().get(i).getIcaocode();
	   	     uri = "https://tgftp.nws.noaa.gov/data/observations/metar/stations/"+icaocode+".TXT";	
	   	     result=restTemplate.getForObject(uri, String.class);;
	   	     data=result.substring(17);
	   	     time=result.substring(0, 16);
	   	    // System.out.println("time " + time);
	   	    // System.out.println("metar time " + metarService.findTopByIcaoCodeOrderByTimeDesc(icaocode).getTime());
	   	     if(!time.contentEquals(metarService.findTopByIcaoCodeOrderByTimeDesc(icaocode).getTime())) {
	   	     metar.setTime(time);
	   	     metar.setData(data);
	   	     metar.setIcaoCode(icaocode);
	   	     metarService.save(metar);
	   	      System.out.println("Value saved");
	   	     }
	   	     else {
	   	    	 System.out.println("Value already present");
	   	     }
			}
	    
	  
        }
   		
   	}
 


