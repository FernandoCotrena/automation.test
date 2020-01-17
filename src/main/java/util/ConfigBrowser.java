package util;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.client.ClientUtil;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;
import net.thucydides.core.webdriver.DriverSource;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.CapabilityType;

import java.util.concurrent.TimeUnit;

import static net.serenitybdd.core.environment.EnvironmentSpecificConfiguration.from;

public class ConfigBrowser implements DriverSource {
	private static final long SELENIUM_IMPLICIT_WAIT_MILLISECOND = 3000;
	EnvironmentVariables variables = SystemEnvironmentVariables.createEnvironmentVariables();
	private Proxy seleniumProxy;

	@Override
	public WebDriver newDriver() {
		WebBrowsers browserType = WebBrowsers.valueOf(from(variables).getProperty("browser.setup"));

		WebDriver driver = null;

		switch (browserType) {
		case PHANTOMJS:
			WebDriverManager.phantomjs().setup();
			driver = new PhantomJSDriver();
			break;
		case CHROME:
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case CHROME_HEADLESS:
			WebDriverManager.chromedriver().setup();
			ChromeOptions chromeHeadlessOptions = new ChromeOptions();
			chromeHeadlessOptions.addArguments("--headless");
			driver = new ChromeDriver(chromeHeadlessOptions);
			break;

		case FIREFOX_HEADLESS:
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver(setFirefoxOption(true));
			break;
		case FIREFOX:
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver(setFirefoxOption(false));
			break;
		default:
			break;
		}

		driver.manage().timeouts().implicitlyWait(SELENIUM_IMPLICIT_WAIT_MILLISECOND, TimeUnit.MILLISECONDS);
		return driver;
	}

	private FirefoxOptions setFirefoxOption(boolean headless) {
		FirefoxOptions options = new FirefoxOptions();
		options.setCapability(CapabilityType.PROXY, setHeader());
		if (headless) {
			options.addArguments("--headless");
		}
		return options;
	}

	private Proxy setHeader() {
		BrowserMobProxy proxy = new BrowserMobProxyServer();
		proxy.start(0);
		String[] headers = from(variables).getProperty("browser.header").split(":");
		for (int i = 0; i < headers.length - 1; i++) {
			proxy.addHeader(headers[i], headers[i = i + 1]);
		}
		Proxy seleniumProxy = ClientUtil.createSeleniumProxy(proxy);
		return seleniumProxy;
	}

	@Override
	public boolean takesScreenshots() {
		return true;
	}

	private enum WebBrowsers {
		CHROME, CHROME_HEADLESS, FIREFOX, FIREFOX_HEADLESS, PHANTOMJS
	}

}
