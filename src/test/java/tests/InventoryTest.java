package tests;

import base.BaseTest;

import java.util.List;

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

        // Create InventoryPage object
        InventoryPage inventoryPage =
                new InventoryPage(driver);

        // Get only product names
        List<WebElement> products =
                inventoryPage.getProductNames();

        boolean productFound = false;

        // Loop through product names
        for (WebElement product : products) {

            System.out.println(
                    "PRODUCT: " + product.getText()
            );

            if (product.getText()
                    .equals(TestData.BACKPACK)) {

                productFound = true;
                break;
            }
        }

        // Verify backpack exists
        Assert.assertTrue(
                productFound,
                "Backpack product was not found."
        );
    }
}