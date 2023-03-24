package com.items;

import java.util.ArrayList;
import java.util.List;

import com.customexceptions.CheckIDException;
import com.customexceptions.EmptyListException;
import com.customexceptions.IdNotFoundException;

public class ItemDb {

	public static final List<Item> ITEMS = new ArrayList<>();

	public static void presentItems() {
		ITEMS.add(new Item(1, "Pen", 25));
		ITEMS.add(new Item(2, "Book", 45));
		ITEMS.add(new Item(3, "Bag", 450));
		ITEMS.add(new Item(4, "Scale", 35));
		ITEMS.add(new Item(5, "NoteBook", 50));
		ITEMS.add(new Item(6, "Charger", 200));
		ITEMS.add(new Item(7, "Cable", 120));
		ITEMS.add(new Item(8, "Ball", 230));
		ITEMS.add(new Item(9, "TV", 1000));
		ITEMS.add(new Item(10, "Bottle", 90));
	}

	public static List<Item> getItems() {
		presentItems();
		if (ITEMS.isEmpty()) {
			throw new EmptyListException("Items list is empty. Add some!");
		}
		return ITEMS;
	}

	public static Item findItemsById(int id) {
		for (Item item : ITEMS) {
			if (item.getId() == id)
				return item;
		}
		throw new IdNotFoundException("Item Id not found");
	}

}
