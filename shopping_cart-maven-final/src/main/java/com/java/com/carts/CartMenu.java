package com.carts;

import com.displaymenu.MenuDisplay;
import com.inputs.InputChecker;
import com.items.ItemController;
import com.items.ItemDb;
import com.users.UserController;

public class CartMenu {

	private final InputChecker ip;
	private final MenuDisplay menu;
	private final CartController controller;
	private final ItemController itemController;

	public CartMenu(InputChecker ip, MenuDisplay menu, CartController controller, ItemController itemController) {
		this.ip = ip;
		this.menu = menu;
		this.controller = controller;
		this.itemController = itemController;
	}

	public void performAction() {
		while (true) {
			menu.displayCartMenu();

			int ch = 0;
			try {
				ch = ip.readId("choice: ");
			} catch (Exception e) {
				System.out.println("\n ❌ Enter Numbers Only \n");
			}

			if (ch >= 5) {
				System.out.println("\n 🙏 Thanks for using our services");
				break;
			} else {
				if (ch == 1) {

//					int cartId = ip.readId("Cart Id: ");
//					controller.addcart(cartId);

					itemController.getAllItems();
					int itemId = ip.readId("Item Id: ");
					ItemDb.findItemsById(itemId);
					int qua = ip.readId("Quantity: ");
					controller.addItemToCart(itemId, qua);

				}
				if (ch == 2) {
					System.out.println("\n 👏 Displaying The Cart \n");
					int cartId = ip.readId("Cart Id: ");
					controller.listCartItems(cartId);
				}
				if (ch == 3) {
					int cartId = ip.readId("Cart Id: ");
					int itemId = ip.readId("Item Id: ");
					controller.removeItemFromCart(cartId, itemId);
				}
				if (ch == 4) {
					int cartId = ip.readId("Cart Id: ");
					controller.totalCartAmount(cartId);
				}
			}
			System.out.println("========================================\n\n");
		}
	}

}
