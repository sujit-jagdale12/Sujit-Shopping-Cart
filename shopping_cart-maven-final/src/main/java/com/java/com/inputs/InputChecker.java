package com.inputs;

import java.util.Scanner;

import com.customexceptions.CheckIDException;
import com.customexceptions.NameNotNullException;
import com.customexceptions.NegativePriceException;

public class InputChecker {
	private final Scanner sc;

	public InputChecker() {
		sc = new Scanner(System.in);
	}

	private int readInput() {
		int num = 0;
		try {
			num = sc.nextInt();
		} catch (Exception e) {
			sc.next();
			throw new CheckIDException("plz enter number only");
		}
		return num;
	}

	public int readId(String msg) {
		System.out.print("👉 Enter " + msg);
		int num = readInput();
		if (num <= 0)
			throw new CheckIDException("number can't be negative or zero");
		return num;
	}

	public String readName(String msg) {
		System.out.print("👉 Enter " + msg);
		sc.nextLine();
		String name = sc.nextLine();
		if (name == null || name.length() == 0)
			throw new NameNotNullException("Name can't be null");
		else if (name.length() <= 3)
			throw new NameNotNullException("length of name is too short");

		return name;
	}

	public double readPrice(String msg) {
		System.out.print("👉 Enter " + msg);
		double price = sc.nextDouble();

		if (price <= 0)
			throw new NegativePriceException("Price can't be negative");
		if (price == 0)
			throw new NegativePriceException("Price can't be zero");
		return price;
	}
}
