package nz.ac.auckland.se281.a2;

import nz.ac.auckland.se281.a2.cli.Menu.SIZE;

public class Combos extends Cart {

	Burgers comboBurger;
	Snacks comboSnack;
	Drinks comboDrink;

	public Combos(String nameBurger, float priceBurger, String nameSnack, float priceSnack, String nameDrink,
			float priceDrink, SIZE size) {

		// creates a burger, snack and drink instance to the combo
		this.comboBurger = new Burgers(nameBurger, priceBurger);
		this.comboSnack = new Snacks(nameSnack, priceSnack, size);
		this.comboDrink = new Drinks(nameDrink, priceDrink, size);
	}

	// appending toString to combo format
	@Override
	public String toString() {
		return " - COMBO : (" + comboBurger.itemName + ", " + comboSnack.itemName + " (" + comboSnack.size + "), "
				+ comboDrink.itemName + " (" + comboDrink.size + ")): " + "$" + String.format("%.02f", price);
	}

}
