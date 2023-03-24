package com.carts;

import java.util.ArrayList;
import java.util.List;

import com.customexceptions.CartNotFoundException;
import com.items.Item;
import com.items.ItemDb;
import com.users.User;
import com.users.UserDb;

public class CartDb {

	private final static List<Cart> CARTS = new ArrayList<>();

	public static void addCart(int cartId, int userId) {
		User user = UserDb.findUserById(userId);
		Cart cart = new Cart();
		cart.setId(cartId);
		cart.setUser(user);

		CARTS.add(cart);
	}

	public static String addItemToCart(int userId, int itemId, int quantity) {
		User user = UserDb.findUserById(userId);
		Cart cart = user.getCart();
		Item item = ItemDb.findItemsById(itemId);
		item.setQuantity(quantity);

		cart.getItems().add(item);

		return "✔✔Item added successfully";
	}

	public static List<Cart> cartItems() {
		return CARTS;
	}

	public static Cart findCartById(int cartId) {
		for (Cart cart : CARTS) {
			if (cart.getId() == cartId) {
				return cart;
			}
		}
		throw new CartNotFoundException("Cart id is not found.");
	}

	public static List<Item> findItemsByCartId(int cartId) {
		return findCartById(cartId).getItems();
	}

	public static boolean removeItem(int cartId, int itemId) {
		List<Item> itemList = findItemsByCartId(cartId);
		Item item = ItemDb.findItemsById(itemId);
		boolean remove = itemList.remove(item);

		return remove;
	}

	public static double totalBill(int cartId) {
		double bill = 0;
		List<Item> items = findItemsByCartId(cartId);
		for (Item item : items) {
			System.out.println(item);
			bill += (item.getPrice() * item.getQuantity());
		}
		return bill;
	}

}
