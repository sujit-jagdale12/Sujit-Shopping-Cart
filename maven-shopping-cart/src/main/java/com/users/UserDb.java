package com.users;

import java.util.ArrayList;
import java.util.List;

import com.customexceptions.CheckIDException;
import com.customexceptions.EmptyListException;
import com.customexceptions.IdNotFoundException;

public class UserDb {

	public static final int USER_CREATED = 990;
	public static final int ALREADY_EXISTS = 1001;

	public static final List<User> USERS = new ArrayList<>();

	public static int addUser(int id, String name) {
		for (User user : USERS) {
			if (user.getId() == id)
				return ALREADY_EXISTS;
		}
		User user = new User(id, name);
		USERS.add(user);
		return USER_CREATED;
	}

	public static List<User> listUsers() {
		if (USERS.isEmpty()) {
			throw new EmptyListException("list is empty add some users");
		}
		return USERS;
	}

	public static User findUserById(int id) {
		for (User user : USERS) {
				if (user.getId() == id)
					return user;
		}
		throw new IdNotFoundException(id + " user id not found! add user first.");
	}

}
