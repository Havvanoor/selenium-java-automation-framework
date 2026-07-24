package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

    public static WebDriver getDriver() {

        String browser = ConfigReader.getProperty("browser");

        WebDriver driver;

        if (browser.equalsIgnoreCase("chrome")) {

            driver = new ChromeDriver();

        } else if (browser.equalsIgnoreCase("firefox")) {

            driver = new FirefoxDriver();

        } else {

            throw new IllegalArgumentException(
                    "Browser not supported: " + browser
            );

        }

        return driver;

    }
}