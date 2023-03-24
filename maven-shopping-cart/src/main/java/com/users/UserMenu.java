package com.users;

import com.carts.CartController;
import com.carts.CartMenu;
import com.displaymenu.MenuDisplay;
import com.inputs.InputChecker;

public class UserMenu {

	private final InputChecker input;
	private final MenuDisplay menuDisplay;
	private final UserController userController;
	private final CartController cartController;
	private final CartMenu cartMenu;

	public UserMenu(InputChecker input, MenuDisplay menuDisplay, UserController userController, CartController cartController,
			CartMenu cartMenu) {
		this.input = input;
		this.menuDisplay = menuDisplay;
		this.userController = userController;
		this.cartController = cartController;
		this.cartMenu = cartMenu;
	}

	public void actionPerform() {
		while (true) {
			menuDisplay.displayUserMenu();

			int choice = 0;
			try {
				choice = input.readId("choice: ");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

			if (choice == 4) {
				System.out.println("Thank you for your service");
				break;
			} else {
				if (choice == 1) {
					try {
						int id = input.readId("User Id: ");
						String name = input.readName("User Name: ");
						userController.createUser(id, name);
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				} else if (choice == 2) {
					try {
						userController.printUsers();
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				} else if (choice == 3) {
					try {
						int id = input.readId("User Id: ");
						UserDb.findUserById(id);
						cartController.setUserID(id);
						cartMenu.performAction();
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				}
			}
			System.out.println("========================================\n\n");
		}
	}

}
