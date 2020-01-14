import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {
    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void logout() {
        login();
        driver.findElement(By.id("user-container")).click();
        driver.findElement(By.linkText("Cerrar sesión")).click();
    }

    @Test
    public void login() {
        driver.get("https://www.lavoz.com.ar/");
        driver.manage().window().maximize();
        driver.findElement(By.cssSelector(".is-small > .is-hidden-tablet-only")).click();
        driver.findElement(By.id("email")).sendKeys("fernandocotrena@gmail.com");
        driver.findElement(By.id("password")).sendKeys("Sawueso123");
        driver.findElement(By.cssSelector(".has-primary")).click();
    }
}
