package nz.ac.auckland.se281.a2;

import nz.ac.auckland.se281.a2.cli.Menu.SIZE;

public class Snacks extends CartItems {

	// constructor snacks takes in size as well
	public Snacks(String itemName, float price, SIZE size) {
		super(itemName, price);
		this.size = size;
		setPrice();
	}

	// appending toString to add size
	@Override
	public String toString() {
		return " - " + itemName + " (" + size + "): " + "$" + String.format("%.02f", price);
	}

}
