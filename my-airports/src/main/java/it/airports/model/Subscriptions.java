package it.airports.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Subscriptions {
	
	
	@Id
	@Column(name = "icaocode")
	private String icaoCode;
	
	@Column(name = "description")
	private String description;

	
	public String getIcaocode() {
		return icaoCode;
	}
	public void setIcaocode(String icaoCode) {
		this.icaoCode = icaoCode;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Subscriptions(String icaoCode, String description) {
		super();
		this.icaoCode = icaoCode;
		this.description = description;
		
	}
	public Subscriptions() {
		super();
	}

}
