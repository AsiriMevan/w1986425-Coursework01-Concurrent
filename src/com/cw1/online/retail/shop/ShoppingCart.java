/**
 * @author : Mevan Senanayake
 * Date : 5/20/2023
 * Time : 2:04 AM
 * Package Name : com.cw1.online.retail.shop
 * Project Name : w1986425-Coursework01-Concurrent
 */
package com.cw1.online.retail.shop;

import java.util.ArrayList;
import java.util.List;

// Represents a shopping cart that stores selected goods.
public class ShoppingCart {
    private final List<Goods> items;

    public ShoppingCart() {
        this.items = new ArrayList<>();
    }

    // Method to add an item to the shopping cart
    public synchronized void addItem(Goods item) {
        items.add(item);
        System.out.println("Selected Good added to the Shopping Cart:" + " " + item.getName());
    }

    // Method to remove an item from the shopping cart
    public synchronized void deleteItem(Goods item) {
        items.remove(item);
        System.out.println("Selected Good removed from the Shopping Cart: " + " " + item.getName());
    }

    // Method to check out the items in the shopping cart
    public synchronized void checkout() {
        for (Goods item : items) {
            if (item.getQuantity() > 0) {
                item.updateGoodsQuantity(item.getQuantity() - 1);
                System.out.println("Item Checked out:" + " " + item.getName());
            } else {
                System.out.println("Item is out of stock:" + " " + item.getName());
            }
        }
        items.clear();
    }
}
