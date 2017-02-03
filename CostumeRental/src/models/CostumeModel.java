package models;

public class CostumeModel {

	private int id;
	private String name;
	private int price;
	private boolean available;
	
	public CostumeModel(int id, String name, int price, boolean available) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.available = available;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}


	
}
