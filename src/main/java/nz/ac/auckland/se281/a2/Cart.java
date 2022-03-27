package nz.ac.auckland.se281.a2;

import nz.ac.auckland.se281.a2.cli.Menu.SIZE;

public abstract class Cart {

	// creates fields common across all food items
	protected String itemName;
	protected float price;
	protected SIZE size;

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
			this.price += 3;
		case XL:
			this.price += 4;
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
