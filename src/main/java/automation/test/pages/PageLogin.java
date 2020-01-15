package automation.test.pages;

import automation.test.util.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageLogin {

    private WebDriver driver;

    public static String URL = "https://www.lavoz.com.ar/";
    private By btnGotoLogin = By.cssSelector(".is-small > .is-hidden-tablet-only");
    private By txtUser = By.id("email");
    private By txtPass = By.id("password");
    private By username = By.id("user-name");
    private By btnLogin = By.cssSelector(".has-primary");
    private By optionMenu = By.id("user-container");
    private By btnLogout = By.linkText("Cerrar sesión");

    public PageLogin() {
        this.driver = Browser.getDriver();
    }

    public void logout() {
        driver.findElement(optionMenu).click();
        driver.findElement(btnLogout).click();
    }

    public void login(String user, String password) {
        driver.findElement(btnGotoLogin).click();
        driver.findElement(txtUser).sendKeys(user);
        driver.findElement(txtPass).sendKeys(password);
        driver.findElement(btnLogin).click();
    }

    public boolean isConnecting() {
        return driver.findElement(optionMenu).isEnabled();
    }
}
