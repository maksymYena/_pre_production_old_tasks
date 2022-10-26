package com.epam.maksym_yena.test_automation.task13;

import com.codeborne.selenide.Selenide;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import com.codeborne.selenide.Configuration;

public class TestSelenoid {

    @BeforeSuite
    public void setUp() {

        Configuration.baseUrl = "https://yandex.ru/";
        Configuration.browser = "SelenoidDriverProvider";
        Configuration.timeout = 10000;
        Configuration.browserSize = "1600x1400";
    }

    @AfterSuite
    public void cleanUp() {
        Selenide.close();
    }
}
