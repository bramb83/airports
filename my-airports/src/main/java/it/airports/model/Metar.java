package it.airports.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Metar {
	
	@Id
	@Column(name = "icaocode")
	private String icaoCode;
	@Column(name = "time")
	private Timestamp time;
	


	@Column(name = "data")
	private String data;

	public String getIcaoCode() {
		return icaoCode;
	}

	public void setIcaoCode(String icaoCode) {
		this.icaoCode = icaoCode;
	}

	public Timestamp getTime() {
		return time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}
	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Metar(String icaoCode, Timestamp time, String data) {
		super();
		this.icaoCode = icaoCode;
		this.time = time;
		this.data = data;
	}
	
	public Metar() {
		super();
	}
	
	

}
