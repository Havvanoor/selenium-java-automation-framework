package tests;

import base.BaseTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.InventoryPage;

import utilities.TestData;

public class LoginTests extends BaseTest {


    @Test
    public void validLoginTest() {

        // Login with valid credentials

        login(
                TestData.VALID_USERNAME,
                TestData.VALID_PASSWORD
        );


        // Create InventoryPage

        InventoryPage inventoryPage =
                new InventoryPage(driver);


        // Get actual title

        String actualTitle =
                inventoryPage.getInventoryTitle();


        // Verify title

        Assert.assertEquals(
                actualTitle,
                "Products"
        );

    }


    @Test
    public void lockedUserLoginTest() {

        // Login with locked user

        login(
                TestData.LOCKED_USERNAME,
                TestData.VALID_PASSWORD
        );


        // Get error message


        String actualErrorMessage =
                loginPage.getErrorMessage();


        // Verify error message

        Assert.assertTrue(
                actualErrorMessage.contains(
                        "Sorry, this user has been locked out"
                )
        );

    }

}