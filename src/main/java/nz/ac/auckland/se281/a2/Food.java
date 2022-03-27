package nz.ac.auckland.se281.a2;

public abstract class Food {

	// creates fields common across all food items
	protected String itemName;
	protected float price;

	public Food(String itemName, float price) {
		this.itemName = itemName;
		this.price = price;
	}

	// overrides toString to print required information
	@Override
	public String toString() {
		return " - " + itemName + ": " + "$" + String.format("%.02f", price);
	}
}
