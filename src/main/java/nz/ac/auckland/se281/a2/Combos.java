package nz.ac.auckland.se281.a2;

public class Combos extends Cart {

	String nameBurger;
	float priceBurger;
	String nameSnack;
	float priceSnack;
	String nameDrink;
	float priceDrink;

	public Combos(String itemName, float price, String nameBurger, float priceBurger, String nameSnack,
			float priceSnack, String nameDrink, float priceDrink) {
		super(itemName, price);
		this.nameBurger = nameBurger;
		this.priceBurger = priceBurger;
		this.nameSnack = nameSnack;
		this.priceSnack = priceSnack;
		this.nameDrink = nameDrink;
		this.priceDrink = priceDrink;
	}

}
