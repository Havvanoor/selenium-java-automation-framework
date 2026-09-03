package tests;

import base.BaseTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CartPage;
import pages.InventoryPage;

import utilities.TestData;

public class CartTest extends BaseTest {

    @Test
    public void addProductToCartTest() {

        // Login

        login(
                TestData.VALID_USERNAME,
                TestData.VALID_PASSWORD
        );


        // Inventory Page

        InventoryPage inventoryPage =
                new InventoryPage(driver);


        // Add product to cart

        inventoryPage.addProductToCart(
                TestData.BACKPACK
        );


        // Cart Page

        CartPage cartPage =
                new CartPage(driver);


        // Open cart

        cartPage.openCart();


        // Get actual product name

        String actualProductName =
                cartPage.getProductName();


        // Get actual quantity

        String actualQuantity =
                cartPage.getProductQuantity();


        // Get actual price

        String actualPrice =
                cartPage.getProductPrice();


        // Verify product name

        Assert.assertEquals(
                actualProductName,
                TestData.BACKPACK
        );


        // Verify quantity

        Assert.assertEquals(
                actualQuantity,
                TestData.BACKPACK_QUANTITY
        );

        // Verify price

        Assert.assertEquals(
                actualPrice,
                TestData.BACKPACK_PRICE
        );

    }

}