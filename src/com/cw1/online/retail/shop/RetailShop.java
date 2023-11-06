/**
 * @author : Mevan Senanayake
 * Date : 5/20/2023
 * Time : 9:57 AM
 * Package Name : com.cw1.online.retail.shop
 * Project Name : w1986425-Coursework01-Concurrent
 */
package com.cw1.online.retail.shop;

//Represents a retail shop that manages shopping carts and the system administrator.
public class RetailShop {
    private ShoppingCart shoppingCart;
    private SystemAdministrator checkoutManager;

    public RetailShop() {
        this.shoppingCart = new ShoppingCart();
        this.checkoutManager = new SystemAdministrator();
    }

    // Method for shoppers to add items to their shopping carts
    public void addItemToCart(Goods... goods) {
        for (Goods good : goods) {
            shoppingCart.addItem(good);
        }
    }

    // Method for shoppers to check out items from their shopping carts
    public void checkout() {
        shoppingCart.checkout();
    }

    // Method for the system administrator to update the quantity of a goods
    public void updateGoodsQuantity(Goods goods, int newQuantity) {
        checkoutManager.updateGoodsQuantity(goods, newQuantity);
    }
}
