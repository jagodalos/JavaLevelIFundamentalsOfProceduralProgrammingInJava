package model;

import java.sql.Timestamp;
import java.time.LocalDate;

public class Rent {

	private int id;
	private Costume costume;
	private Timestamp dateTime;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Costume getCostume() {
		return costume;
	}
	public void setCostume(Costume costume) {
		this.costume = costume;
	}
	public Timestamp getDateTime() {
		return dateTime;
	}
	public void setDateTime(Timestamp dateTime) {
		this.dateTime = dateTime;
	}

}
