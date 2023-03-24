package com.displaymenu;

public class MenuDisplay {

	public void displayUserMenu() {

		StringBuilder builder = new StringBuilder();
		builder.append("🔥 User Menu 🔥").append("\n").append("-------------------").append("\n")
				.append("Select Your Choice").append("\n").append("-------------------").append("\n")
				.append("1. New User").append("\n").append("2. List Users").append("\n").append("3. Go to cart menu")
				.append("\n").append("4. Exit").append("\n\n");

		System.out.println(builder.toString());
	}

	public void displayCartMenu() {
		StringBuilder builder = new StringBuilder();
		builder.append("🔥 Cart Menu 🔥").append("\n").append("-------------------").append("\n")
				.append("Select Your Choice").append("\n").append("-------------------").append("\n")
				.append("1. Add To Cart ").append("\n").append("2. Show Cart").append("\n")
				.append("3. Remove From Item").append("\n").append("4. Cart Total").append("\n").append("5. Exit")
				.append("\n");

		System.out.println(builder.toString());
	}
}
