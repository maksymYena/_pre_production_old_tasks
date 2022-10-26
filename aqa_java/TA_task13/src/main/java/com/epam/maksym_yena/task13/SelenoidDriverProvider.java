package com.epam.maksym_yena.task13;

import com.codeborne.selenide.WebDriverProvider;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URI;

public class SelenoidDriverProvider implements WebDriverProvider {

    @Override
    public WebDriver createDriver(DesiredCapabilities desiredCapabilities) {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("chrome");
        capabilities.setVersion("80.0");
        capabilities.setPlatform(Platform.WINDOWS);
        capabilities.setCapability("enableVNC", true);
        try {
            RemoteWebDriver driver = new RemoteWebDriver(
                    URI.create("http://161.35.78.225:4444/wd/hub").toURL(),
                    capabilities
            );
            return driver;
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}