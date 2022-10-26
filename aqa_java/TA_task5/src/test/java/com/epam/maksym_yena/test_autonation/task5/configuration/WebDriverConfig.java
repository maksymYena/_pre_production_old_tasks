package com.epam.maksym_yena.test_autonation.task5.configuration;

import com.codeborne.selenide.WebDriverRunner;
import com.epam.maksym_yena.test_autonation.task5.enumeration.WebDriversEnumeration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverConfig {

    private static WebDriver driver;

    public static void setWebDriver(WebDriversEnumeration driver) {
        switch (driver) {
            case CHROME: {
                WebDriverRunner.setWebDriver(new ChromeDriver());
                return;
            }
            case FIREFOX: {
                WebDriverRunner.setWebDriver(new FirefoxDriver());
                return;
            }
            default:
                throw new IllegalStateException("Unsupported browser");
        }
    }

    public static void closeWebDriver() {
        if(WebDriverRunner.getWebDriver()!= null) {
            WebDriverRunner.getWebDriver().close();
        }
    }

    public static void cleanUp() {
        if(WebDriverRunner.getWebDriver()!= null) {
            WebDriverRunner.getWebDriver().manage().deleteAllCookies();
        }
    }

}
