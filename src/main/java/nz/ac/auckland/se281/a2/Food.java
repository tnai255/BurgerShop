package nz.ac.auckland.se281.a2;

public abstract class Food {

	// creates fields common across all food items
	protected String itemName;
	protected float price;
	protected int cartId = -1;

	public Food(String itemName, float price) {
		this.itemName = itemName;
		this.price = price;
		// if food instance constructed adds 1 to the cartId
		this.cartId++;
	}

	// overrides toString to print required information
	@Override
	public String toString() {
		return cartId + " - " + itemName + ": " + "$" + String.format("%.02f", price);
	}
}
