package nz.ac.auckland.se281.a2;

import nz.ac.auckland.se281.a2.cli.Menu.SIZE;

public class Combos extends CartItems {

	private Burgers comboBurger;
	private Snacks comboSnack;
	private Drinks comboDrink;

	// creates a combo constructor
	public Combos(String nameBurger, float priceBurger, String nameSnack, float priceSnack, String nameDrink,
			float priceDrink, SIZE size) {

		// creates a burger, snack and drink instance to the combo
		this.comboBurger = new Burgers(nameBurger, priceBurger);
		this.comboSnack = new Snacks(nameSnack, priceSnack, size);
		this.comboDrink = new Drinks(nameDrink, priceDrink, size);

		// calls overwritten set price
		setPrice();
	}

	// changes price to be the total of the burger, snack and drink instances
	@Override
	public void setPrice() {
		price = comboBurger.price + comboSnack.price + (comboDrink.price / 2);
	}

	// appending toString to combo format
	@Override
	public String toString() {
		return " - COMBO : (" + comboBurger.itemName + ", " + comboSnack.itemName + " (" + comboSnack.size + "), "
				+ comboDrink.itemName + " (" + comboDrink.size + ")): " + "$" + String.format("%.02f", price);
	}

}
