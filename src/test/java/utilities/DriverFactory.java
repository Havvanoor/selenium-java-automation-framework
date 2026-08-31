package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import utilities.ConfigReader;

public class DriverFactory {

    public static WebDriver getDriver() {

        // config.properties dosyasından browser bilgisini alır
        String browser = ConfigReader.getProperty("browser");

        WebDriver driver;

        // CHROME
        if (browser.equalsIgnoreCase("chrome")) {

            // Chrome browser ayarlarını oluşturur
            ChromeOptions options = new ChromeOptions();

            /*
             * Terminalden headless değeri verilmiş mi kontrol eder.
             *
             * mvn test
             *      -> headless = false
             *
             * mvn test -Dheadless=true
             *      -> headless = true
             */
            boolean headless = Boolean.parseBoolean(
                    System.getProperty("headless", "false")
            );

            // Headless true ise Chrome ekranda görünmeden çalışır
            if (headless) {

                options.addArguments("--headless=new");
            }

            // Chrome'u belirlediğimiz options ile başlatır
            driver = new ChromeDriver(options);

        }

        // FIREFOX
        else if (browser.equalsIgnoreCase("firefox")) {

            driver = new FirefoxDriver();

        }

        // Desteklenmeyen browser
        else {

            throw new IllegalArgumentException(
                    "Browser not supported: " + browser
            );
        }

        // Oluşturulan driver'ı geri döndürür
        return driver;
    }
}