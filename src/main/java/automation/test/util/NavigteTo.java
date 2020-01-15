package automation.test.util;

import static automation.test.util.Browser.getDriver;

public class NavigteTo {

    public static void navigeTo(String url) {
        getDriver().get(url);
    }
}
