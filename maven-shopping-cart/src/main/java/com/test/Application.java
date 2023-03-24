package com.test;

import com.carts.CartController;
import com.carts.CartMenu;
import com.displaymenu.MenuDisplay;
import com.inputs.InputChecker;
import com.items.ItemController;
import com.users.UserController;
import com.users.UserMenu;

public class Application {

	public static void main(String[] args) {

		InputChecker input = new InputChecker();
		MenuDisplay menuDisplay = new MenuDisplay();
		UserController userController = new UserController();
		CartController cartController = new CartController();
		ItemController itemController=new ItemController();
		CartMenu cartMenu = new CartMenu(input, menuDisplay, cartController, itemController);

		UserMenu menu = new UserMenu(input, menuDisplay, userController, cartController, cartMenu);
		menu.actionPerform();

	}
}

