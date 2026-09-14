package com.ltp.globalsuperstore.repository;

import java.util.List;
import java.util.ArrayList;

import com.ltp.globalsuperstore.Item;

public class StoreRepository {

    List<Item> items = new ArrayList<>();

    public Item getItem(int index) {
        return items.get(index);
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void updateItem(Item item, int index) {
        items.set(index, item);
    }

    public List<Item> getItems() {
        return items;
    }
}