package nz.ac.auckland.se281.a2;

import nz.ac.auckland.se281.a2.cli.Menu.SIZE;

public class Snacks extends Food {

	SIZE size;

	// constructor snacks takes in size as well
	public Snacks(String itemName, float price, SIZE size) {
		super(itemName, price);
		this.size = size;
	}

}
