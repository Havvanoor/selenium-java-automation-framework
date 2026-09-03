package base;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import pages.LoginPage;

import utilities.ConfigReader;
import utilities.DriverFactory;

public class BaseTest {

    protected WebDriver driver;
    protected LoginPage loginPage;

    @BeforeMethod
    public void setUp() {

        driver = DriverFactory.getDriver();

        driver.manage()
                .window()
                .maximize();

        driver.get(
                ConfigReader.getProperty("url")
        );

        loginPage = new LoginPage(driver);
    }


    // Take screenshot
    public void takeScreenshot(String testName) {

        TakesScreenshot screenshot =
                (TakesScreenshot) driver;

        File sourceFile =
                screenshot.getScreenshotAs(
                        OutputType.FILE
                );

        String screenshotPath =
                "screenshots/"
                        + testName
                        + ".png";

        try {

            Path destination =
                    Paths.get(
                            screenshotPath
                    );

            Files.createDirectories(
                    destination.getParent()
            );

            Files.copy(
                    sourceFile.toPath(),
                    destination,
                    StandardCopyOption.REPLACE_EXISTING
            );

            System.out.println(
                    "Screenshot saved: "
                            + screenshotPath
            );

        } catch (IOException e) {

            e.printStackTrace();
        }
    }


    @AfterMethod
    public void tearDown(ITestResult result) {

        // Take screenshot if test fails
        if (result.getStatus()
                == ITestResult.FAILURE) {

            takeScreenshot(
                    result.getName()
            );
        }

        // Close browser
        if (driver != null) {

            driver.quit();
        }
    }


    protected void login(
            String username,
            String password) {

        loginPage.login(
                username,
                password
        );
    }
}