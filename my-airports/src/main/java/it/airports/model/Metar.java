package it.airports.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;


@Entity
@IdClass(Metar.class)
public class Metar implements Serializable {
	
	@Id
	@Column(name = "icaocode")
	private String icaoCode;
	@Id
	@Column(name = "time")
	private String time;
	


	@Column(name = "data")
	private String data;

	public String getIcaoCode() {
		return icaoCode;
	}

	public void setIcaoCode(String icaoCode) {
		this.icaoCode = icaoCode;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String string) {
		this.time = string;
	}
	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Metar(String icaoCode, String time, String data) {
		super();
		this.icaoCode = icaoCode;
		this.time = time;
		this.data = data;
	}
	
	public Metar() {
		super();
	}
	
	

}
