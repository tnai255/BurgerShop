package nz.ac.auckland.se281.a2;

import nz.ac.auckland.se281.a2.cli.Menu.SIZE;

public class Combos extends Cart {

	public Combos(String nameBurger, float priceBurger, String nameSnack, float priceSnack, String nameDrink,
			float priceDrink, SIZE size) {
		super(nameBurger + nameSnack + nameDrink, priceBurger + priceSnack + priceDrink);
		this.size = size;
		setPrice();
	}

	// appending toString to combo format
	@Override
	public String toString() {
		return " - COMBO " + itemName + " (" + size + "): " + "$" + String.format("%.02f", price);
	}

}
