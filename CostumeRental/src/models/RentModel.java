package models;

import java.time.LocalDate;

public class RentModel {

	final private CostumeModel costume;
	final private CustomerModel customer;
	final private LocalDate date;

	public RentModel(CostumeModel costume, CustomerModel customer, LocalDate date) {
		super();
		this.costume = costume;
		this.customer = customer;
		this.date = date;
	}

	public CostumeModel getCostume() {
		return costume;
	}

	public CustomerModel getCustomer() {
		return customer;
	}

	public LocalDate getDate() {
		return date;
	}
}
