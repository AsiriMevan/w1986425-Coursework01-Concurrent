/**
 * @author : Mevan Senanayake
 * Date : 5/20/2023
 * Time : 9:50 AM
 * Package Name : com.cw1.online.retail.shop
 * Project Name : w1986425-Coursework01-Concurrent
 */
package com.cw1.online.retail.shop;

// Represents a system administrator who can update the quantity of goods.
public class SystemAdministrator {

    // Method for the Checkout Manger to update the quantity of the goods
    public synchronized void updateGoodsQuantity(Goods good, int newQuantity){
        good.updateGoodsQuantity(newQuantity);
    }
}
