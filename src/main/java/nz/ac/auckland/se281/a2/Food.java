package nz.ac.auckland.se281.a2;

public abstract class Food {

	protected String itemName;
	protected float price;
	protected int cartId = -1;

	public Food(String itemName, float price) {
		this.itemName = itemName;
		this.price = price;
		this.cartId++;
	}

	public String getItemName() {
		return itemName;
	}

	public float getPrice() {
		return price;
	}

	public int getCardId() {
		return cartId;
	}

	@Override
	public String toString() {
		return cartId + " - " + itemName + ": " + "$" + String.format("%.02f", price);
	}
}
