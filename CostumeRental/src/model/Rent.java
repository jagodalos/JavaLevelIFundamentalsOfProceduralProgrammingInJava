package model;

import java.time.LocalDate;

public class Rent {

	private int id;
	private Costume costume;
	private LocalDate date;
	
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
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}

	
	
	
}
