import automation.test.util.Browser;
import automation.test.pages.PageLogin;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static automation.test.util.Browser.getCurrentUrl;
import static automation.test.util.NavigteTo.navigeTo;

public class Run {
    private PageLogin pageLogin;

    @Before
    public void setUp() {
        pageLogin = new PageLogin();
    }

    @After
    public void tearDown() {
        Browser.quitDriver();
    }

    @Test
    public void login() {
        navigeTo(PageLogin.URL);
        pageLogin.login("fernandocotrena@gmail.com", "Sawueso123");
        Assert.assertTrue(pageLogin.isConnecting());
    }

    @Test
    public void logout() {
        navigeTo(PageLogin.URL);
        pageLogin.login("fernandocotrena@gmail.com", "Sawueso123");
        pageLogin.logout();
        Assert.assertEquals("Pagina Principal", "https://www.lavoz.com.ar/", getCurrentUrl());
    }


}
