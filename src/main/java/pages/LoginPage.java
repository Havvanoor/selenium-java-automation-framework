package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    private WebDriver driver;

    private WebDriverWait wait;


    // Locators

    private By usernameInput =
            By.id("user-name");

    private By passwordInput =
            By.id("password");

    private By loginButton =
            By.id("login-button");

    private By errorMessage =
            By.cssSelector("[data-test='error']");


    // Constructor

    public LoginPage(WebDriver driver) {

        this.driver = driver;

        wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(10)
        );

    }


    // Enter username

    public void enterUsername(String username) {

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        usernameInput
                )
        ).sendKeys(username);

    }


    // Enter password

    public void enterPassword(String password) {

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        passwordInput
                )
        ).sendKeys(password);

    }


    // Click login button

    public void clickLogin() {

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        loginButton
                )
        ).click();

    }


    // Login method

    public void login(
            String username,
            String password) {

        enterUsername(username);

        enterPassword(password);

        clickLogin();

    }


    // Get error message

    public String getErrorMessage() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        errorMessage
                )
        ).getText();

    }

}