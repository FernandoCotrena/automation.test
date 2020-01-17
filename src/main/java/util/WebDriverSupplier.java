package util;

import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class WebDriverSupplier {

    public static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            ConfigBrowser browser = new ConfigBrowser();
            driver = browser.newDriver();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

}
