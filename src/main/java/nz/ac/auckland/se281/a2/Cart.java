package nz.ac.auckland.se281.a2;

import nz.ac.auckland.se281.a2.cli.Menu.SIZE;

public abstract class Cart {

	// creates fields common across all food items
	protected String itemName;
	protected float price;
	protected SIZE size;

	// allows combo constructor to be different
	public Cart() {

	}

	public Cart(String itemName, float price) {
		this.itemName = itemName;
		this.price = price;
	}

	// changes price depending on size
	public void setPrice() {
		switch (size) {
		case L:
			this.price += 3.00;
			break;
		case XL:
			this.price += 4.00;
			break;
		// System.out.println(price);
		default:
			break;
		}
	}

	// overrides toString to print required information
	@Override
	public String toString() {
		return " - " + itemName + ": " + "$" + String.format("%.02f", price);
	}
}
