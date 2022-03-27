package nz.ac.auckland.se281.a2;

import java.util.ArrayList;

import nz.ac.auckland.se281.a2.cli.Menu.SIZE;
import nz.ac.auckland.se281.a2.cli.MessagesCLI;

public class BurgerShop {

	private ArrayList<CartItems> cart;

	public BurgerShop() {
		this.cart = new ArrayList<CartItems>();
	}

	/**
	 * Add a burger in the cart
	 * 
	 * @param name
	 * @param price
	 */
	public void addBurger(String name, float price) {
		// creates a new burger instance for the burger selected
		Burgers selectedBurger = new Burgers(name, price);
		// adds burger to the cart
		cart.add(selectedBurger);
	}

	/**
	 * add a snack in the cart, if size is L the price should be incremented by $3
	 * if the size is XL the price should be incremented by $4 (@see
	 * nz.ac.auckland.se281.a2.cli.Menu.SIZE)
	 * 
	 * 
	 * @param name
	 * @param price
	 * @param size
	 */
	public void addSnack(String name, float price, SIZE size) {
		// creates a new snack instance for the snack selected
		Snacks selectedSnacks = new Snacks(name, price, size);
		// adds snack to the cart
		cart.add(selectedSnacks);
	}

	/**
	 * 
	 * add a drink in the cart
	 * 
	 * if size is L the price should be incremented by $3 if the size is XL the
	 * price should be incremented by $4 (@see
	 * nz.ac.auckland.se281.a2.cli.Menu.SIZE)
	 * 
	 *
	 * @param name
	 * @param price
	 * @param size
	 */
	public void addDrink(String name, float price, SIZE size) {
		// creates a new drink instance for the drink selected
		Drinks selectedDrinks = new Drinks(name, price, size);
		// adds drink to the cart
		cart.add(selectedDrinks);
	}

	/**
	 * print the content of the cart, or print MessagesCLI.CART_EMPTY if the cart is
	 * empty
	 *
	 *
	 */
	public void showCart() {
		// initialises cartID
		int cartId = 0;

		// starts showing cart in a new line from command line
		System.out.println("");

		// checks if cart is empty
		if (cart.isEmpty()) {
			MessagesCLI.CART_EMPTY.printMessage();
		} else {
			// prints each element of the card in a new line
			for (CartItems item : cart) {
				// prints cartID (then increments it) and prints item's toString
				System.out.println((cartId++) + "" + item);
			}
		}

		// calls getTotal method
		getTotal();

	}

	/**
	 * calculates and prints the total of the items in the cart
	 */
	public void getTotal() {

		// initialises total to 0
		float total = 0;

		// loops through all items in cart and adds price to total
		for (CartItems item : cart) {
			total += item.price;
		}

		// checks if total is greater or equal to zero - prints discount message and
		// calculates discount
		if (total >= 100) {
			MessagesCLI.DISCOUNT.printMessage();
			total *= 0.75;
		}

		// prints total
		System.out.println("Total: $" + String.format("%.02f", total));
	}

	/**
	 * add a combo in the cart.
	 * 
	 * The price of a combo is the sum of all the items, but the drink would be half
	 * price. Note that in a combo, both snacks and drinks have the same size, and
	 * the combo price must consider the size (@see addSnack and addDrink methods).
	 * 
	 * @param nameBurger
	 * @param priceBurger
	 * @param nameSnack
	 * @param priceSnack
	 * @param nameDrink
	 * @param priceDrink
	 * @param size
	 */
	public void addCombo(String nameBurger, float priceBurger, String nameSnack, float priceSnack, String nameDrink,
			float priceDrink, SIZE size) {

		// creates a new combo instance
		Combos selectedCombo = new Combos(nameBurger, priceBurger, nameSnack, priceSnack, nameDrink, priceDrink, size);
		// adds combo to cart
		cart.add(selectedCombo);

	}

	/**
	 * remove the item in the cart specified by the position posCart. Note that the
	 * position of the cart start from zero. if postCart is invalid: posCart < 0 OR
	 * posCart >= size of the cart the method prints
	 * MessagesCLI.NOT_VALID_CART_POSITION
	 * 
	 * @param posCart
	 */
	public void removeItem(int posCart) {

		// checks is position of cart is valid i.e. within cart index range
		if (posCart < 0 || posCart >= cart.size()) {
			// prints not valid message
			MessagesCLI.NOT_VALID_CART_POSITION.printMessage();
		} else {
			// if valid it removes item
			cart.remove(posCart);
		}
	}

	/**
	 * removes all elements in the cart
	 */
	public void clearCart() {
		// clears cart my removing all elements in cart arrayList
		cart.clear();
	}

	/**
	 * This method confirms the order, showing the estimated pick up time. It also
	 * give a warning if there are missing opportunities for COMBO menus
	 * 
	 */
	public void confirmOrder() {

		MessagesCLI.ESTIMATE_WAITING_TIME.printMessage();

		if (checkForCombo()) {
			MessagesCLI.MISSED_COMBO.printMessage();
		}

	}

	public boolean checkForCombo() {

		// intialises containBurger and if snacks and drinks are the same size as false
		boolean containsBurger = false;
		boolean sameSize = false;
		// creating empty snacks and drinks array lists to sub list the cart
		ArrayList<Snacks> snacks = new ArrayList<Snacks>();
		ArrayList<Drinks> drinks = new ArrayList<Drinks>();

		// loops through all cart items
		for (CartItems item : cart) {
			// if it contains burger class then it has a burger
			if (item.getClass() == Burgers.class) {
				containsBurger = true;
			}
			// if it has a snack and drink then add them to their respective array list
			if (item.getClass() == Snacks.class) {
				snacks.add((Snacks) item);
			}
			if (item.getClass() == Drinks.class) {
				drinks.add((Drinks) item);

			}
		}

		// loops through snack and array list and checks if any have the same size
		for (Snacks snack : snacks) {
			for (Drinks drink : drinks) {
				if (snack.size == drink.size) {
					sameSize = true;
				}
			}
		}

		// if both conditions met then return true else false
		if (containsBurger && sameSize) {
			return true;
		}

		return false;
	}
}
