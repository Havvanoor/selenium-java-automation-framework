package base;

import org.openqa.selenium.WebDriver;
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

        driver.manage().window().maximize();

        driver.get(ConfigReader.getProperty("url"));

        loginPage = new LoginPage(driver);

    }


    @AfterMethod
    public void tearDown() {

        driver.quit();

    }


    protected void login(String username, String password) {

        loginPage.login(username, password);

    }

}