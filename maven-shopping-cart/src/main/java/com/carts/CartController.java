package com.carts;

import java.util.List;

import com.items.Item;

public class CartController {

	private int userId;

	public void setUserID(int userId) {
		this.userId = userId;
	}

	public void addItemToCart(int itemId, int quantity) {
		String add = CartDb.addItemToCart(userId, itemId, quantity);
		System.out.println(add);
	}

	public void listCartItems(int cartId) {
		List<Item> cartItems = CartDb.findItemsByCartId(cartId);
		System.out.println("Displaying Cart Items.\n");

		System.out.println("-----------------------------------------------------------");
		System.out.printf("%-5s | %-15s | %-15s | %s\n", "ItemId", "ItemName", "ItemPrice", "Quantity");
		System.out.println("-----------------------------------------------------------");

		for (Item item : cartItems) {
			System.out.printf("%-5s | %-15s | %-15.2f |%d\n", item.getId(), item.getName(), item.getPrice(),
					item.getQuantity());
		}
		System.out.println("---------------------------------------------------------------");
	}

	public void removeItemFromCart(int cartId, int itemID) {
		boolean ans = CartDb.removeItem(cartId, itemID);
		if (ans) {
			System.out.println("Item removed.");
		} else {
			System.out.println("Item doesn't removed.");
		}
	}

	public void totalCartAmount(int cartId) {

		double totalBill = CartDb.totalBill(cartId);

		System.out.println("Total bill: " + totalBill);
	}

}
