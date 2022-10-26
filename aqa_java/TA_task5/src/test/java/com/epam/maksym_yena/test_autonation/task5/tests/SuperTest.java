package com.epam.maksym_yena.test_autonation.task5.tests;

import com.epam.maksym_yena.test_autonation.task5.configuration.WebDriverConfig;
import com.epam.maksym_yena.test_autonation.task5.enumeration.WebDriversEnumeration;
import com.epam.maksym_yena.test_autonation.task5.page.Search;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;

public class SuperTest {

    @Before
    public void setUp() {
        WebDriverConfig.setWebDriver(WebDriversEnumeration.CHROME);
    }

    @Test
    public void testFindSelenideSite() {
        open(Search.GOOGLE_URL);
        Search.searchInGoogle();
        Search.clickOnTheFirstLinq();
        Assert.assertTrue(Search.isEquals(Search.getCurrentURL()));
        Search.makeScreenShot();
    }

    @After
    public void cleanUp() {
        WebDriverConfig.cleanUp();
        WebDriverConfig.closeWebDriver();
    }

}
