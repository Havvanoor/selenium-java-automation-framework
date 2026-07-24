package tests;

import java.util.List;

import base.BaseTest;

import org.openqa.selenium.WebElement;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.InventoryPage;

import utilities.TestData;

public class InventoryTest extends BaseTest {


    @Test
    public void verifyBackpackIsDisplayedTest() {

        // Login

        login(
                TestData.VALID_USERNAME,
                TestData.VALID_PASSWORD
        );


        // Create InventoryPage

        InventoryPage inventoryPage =
                new InventoryPage(driver);


        // Get all products

        List<WebElement> products =
                inventoryPage.getAllProducts();


        // Variable to track product

        boolean productFound = false;


        // Loop through all products

        for (WebElement product : products) {

            if (product.getText()
                    .equals(TestData.BACKPACK)) {

                productFound = true;

                break;

            }

        }


        // Verify product is found

        Assert.assertTrue(
                productFound,
                "Backpack product was not found."
        );

    }

}