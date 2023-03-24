package com.items;

import java.util.List;

public class ItemController {

	private final List<Item> items = ItemDb.getItems();

	public ItemController() {
	}

	public void getAllItems() {
		System.out.println("------------------------------------------");
		System.out.printf("%-10s | %-10s | %-10s\n", "ItemId", "ItemName", "ItemPrice");
		System.out.println("------------------------------------------");
		for (Item item : items) {
			if (item != null) {
				System.out.printf("%-10s | %-10s | %s", item.getId(), item.getName(), item.getPrice());
				System.out.println();
			}
		}
		System.out.println("------------------------------------------");
	}
}
