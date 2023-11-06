/**
 * @author : Mevan Senanayake
 * Date : 5/20/2023
 * Time : 1:43 AM
 * Package Name : com.cw1.online.retail.shop
 * Project Name : w1986425-Coursework01-Concurrent
 */
package com.cw1.online.retail.shop;

public class Main {
    public static void main(String[] args) {
        // Create instances of products
        Goods good1 = new Goods(1, "Apple", 10);
        Goods good2 = new Goods(2, "Mango", 20);
        Goods good3 = new Goods(3, "Orange", 30);
        Goods good4 = new Goods(4, "Papaya", 40);

        // Create an instance of the retail shop
        RetailShop retailShop = new RetailShop();

        /***
         * Models of consumers adding their shopping carts with goods : Shopper 01
         */
        Thread shopper01 = new Thread(() -> {
            retailShop.addItemToCart(good1, good3);
        });

        /***
         * Models of consumers adding their shopping carts with goods : Shopper 02
         */
        Thread shopper02 = new Thread(() -> {
            retailShop.addItemToCart(good2, good3);
        });

        /***
         * Models of Administrator adding their shopping carts with goods : Shopper 01
         */
        Thread systemAdministrator = new Thread(() -> {
            retailShop.updateGoodsQuantity(good1, 10);// Adding items to the cart to simulate the system administrator operation
            retailShop.checkout();
        });

        // Start the Thread Group for Shopper01 and  shopper02
        shopper01.start();
        shopper02.start();
        systemAdministrator.start();

        // Wait for the Thread to finish the process
        try {
            shopper01.join();
            shopper02.join();
            systemAdministrator.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        /***
         * Models of consumers checking out their shopping carts with goods : Shopper 02
         */
        Thread shopper03 = new Thread(() -> {
            retailShop.checkout();
        });

        /***
         * Models of consumers checking out their shopping carts with goods : Shopper 03
         */
        Thread shopper04 = new Thread(() -> {
            retailShop.checkout();
        });

        // Start the Thread Group for Shopper03 and  shopper04
        shopper03.start();
        shopper04.start();

        // Wait for the Thread to finish the process
        try {
            shopper03.join();
            shopper04.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
