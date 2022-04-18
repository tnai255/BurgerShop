package nz.ac.auckland.se281.a2;

import java.util.ArrayList;

import nz.ac.auckland.se281.a2.cli.Menu.SIZE;
import nz.ac.auckland.se281.a2.cli.MessagesCLI;

public class BurgerShop {

	// cart arraylist which contains abstract object class
	private ArrayList<CartItems> cart = new ArrayList<CartItems>();
	// indexes of subclasses that stored index of these items in the cart
	private ArrayList<Integer> burgersIndex = new ArrayList<Integer>();
	private ArrayList<Integer> snacksIndex = new ArrayList<Integer>();
	private ArrayList<Integer> drinksIndex = new ArrayList<Integer>();
	private ArrayList<Integer> combosIndex = new ArrayList<Integer>();

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
		Snacks selectedSnack = new Snacks(name, price, size);
		// adds snack to the cart
		cart.add(selectedSnack);
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
		Drinks selectedDrink = new Drinks(name, price, size);
		// adds drink to the cart
		cart.add(selectedDrink);
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

		// checks if cart is empty
		if (cart.isEmpty()) {
			MessagesCLI.CART_EMPTY.printMessage();
		} else {
			// prints each element of the card in a new line
			for (CartItems item : cart) {
				// prints cartID (then increments it) and prints item's toString
				System.out.println((cartId++) + "" + item);
			}
			// calls getTotal method
			getTotal();
		}

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

		// if theres a combo it lets user knpw
		if (checkForCombo()) {
			MessagesCLI.MISSED_COMBO.printMessage();
			// if cart is empty lets user know
		} else if (cart.isEmpty()) {
			MessagesCLI.ORDER_INVALID_CART_EMPTY.printMessage();
			// else places order by showing cart, printing estimated waiting time and
			// clearing cart
		} else {
			showCart();
			System.out.print(MessagesCLI.ESTIMATE_WAITING_TIME.getMessage());
			getWaitingTime();
			clearCart();
		}

	}

	/**
	 * Gets index of Burgers, snacks, drinks in the cart and stores them in their
	 * respective class arrayList
	 */
	public void getSubLists() {

		// clears all item indexes
		burgersIndex.clear();
		snacksIndex.clear();
		drinksIndex.clear();
		combosIndex.clear();

		// loops through all cart items
		for (int itemIndex = 0; itemIndex < cart.size(); itemIndex++) {
			// if item is burger, snack or drink then add their index to their respective
			// array list
			if (cart.get(itemIndex) instanceof Burgers) {
				burgersIndex.add(itemIndex);
			}
			if (cart.get(itemIndex) instanceof Snacks) {
				snacksIndex.add(itemIndex);
			}
			if (cart.get(itemIndex) instanceof Drinks) {
				drinksIndex.add(itemIndex);
			}
			if (cart.get(itemIndex) instanceof Combos) {
				combosIndex.add(itemIndex);
			}
		}

	}

	/**
	 * Checks if theres a combo by calling subLists and checking if conditions of
	 * burger, snack, drink and size are met
	 * 
	 * @return
	 */
	public boolean checkForCombo() {

		// intialises containBurger and if snacks and drinks are the same size as false
		boolean containsBurger = false;
		boolean sameSize = false;

		// calls sublist to create arrays of burgers, drinks, snacks in cart
		getSubLists();

		// checks is cart contains a burger
		if (!burgersIndex.isEmpty()) {
			containsBurger = true;
		}

		// loops through snack and drink index array list and checks if any have the
		// same size
		for (int snackIndex : snacksIndex) {
			for (int drinkIndex : drinksIndex) {
				if (cart.get(snackIndex).size == cart.get(drinkIndex).size) {
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

	/**
	 * Calculates and prints waiting time of order
	 */
	public void getWaitingTime() {

		int hours = 0;
		int minutes = 0;
		int seconds = 0;

		// loops through all the combos and add a burger, snack, drink for each combo
		for (int comboIndex : combosIndex) {
			burgersIndex.add(comboIndex);
			snacksIndex.add(comboIndex);
			drinksIndex.add(comboIndex);
		}

		// checks if each index is not empty then it calculated each item waiting time
		// depending on how much
		if (!burgersIndex.isEmpty()) {
			seconds += (burgersIndex.size() * 60) + 240;
		}

		if (!snacksIndex.isEmpty()) {
			seconds += (snacksIndex.size() * 30) + 150;
		}

		if (!drinksIndex.isEmpty()) {
			seconds += (drinksIndex.size() * 15) + 30;
		}

		// code adapted from https :// stackoverflow.com/a/6118983
		// converting the seconds to hours, minutes and removing these amounts from the
		// seconds
		hours = seconds / 3600;
		minutes = (seconds % 3600) / 60;
		seconds = seconds % 60;

		System.out.println(hours + " hours " + minutes + " minutes " + seconds + " seconds");
	}
}
