package com.users;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class UserController {

	private final UserDb userDb;

	public UserController() {
		userDb = new UserDb();
	}

	public void createUser(int id, String name) {
		int res = UserDb.addUser(id, name);
		
		if (res == UserDb.ALREADY_EXISTS) {
			System.out.println("Entered id is already available!");
		} else if (res == UserDb.USER_CREATED) {
			System.out.println("User succesfully created...");
		}
	}

	public void printUsers() {
		List<User> listUsers = UserDb.listUsers();

		System.out.println("-----------------------");
		System.out.printf("%-6s | %-10s\n", "UserID", "UserName");
		System.out.println("-----------------------");
		for (User user : listUsers) {
			if (user != null)
				System.out.printf("%-6d | %-10s\n", user.getId(), user.getName());
		}
		System.out.println("-----------------------");
	}

}
