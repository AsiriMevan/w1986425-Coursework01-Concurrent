/**
 * @author : Mevan Senanayake
 * Date : 5/20/2023
 * Time : 1:43 AM
 * Package Name : com.cw1.online.retail.shop
 * Project Name : w1986425-Coursework01-Concurrent
 */
package com.cw1.online.retail.shop;

// Represents a goods item with an ID, name, and quantity.
public class Goods {
    private int id;
    private String name;
    private int quantity;

    // Constructor
    public Goods(int id, String name, int quantity) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // Method to update the new quantity of a goods
    public synchronized void updateGoodsQuantity(int newQuantity) {
        this.quantity = newQuantity;
        System.out.println("New Quantity update for Goods:" + " " + name +  " " + "New Quantity:" + " " + quantity);
    }
}
