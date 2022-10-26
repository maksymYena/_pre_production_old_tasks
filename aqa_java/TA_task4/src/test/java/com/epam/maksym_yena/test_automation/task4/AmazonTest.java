package com.epam.maksym_yena.test_automation.task4;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.epam.maksym_yena.test_automation.task4.pages.*;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class AmazonTest extends Constant{


    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "./src/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
        homePage.openPage();
    }

    @Test(priority = 1)
    public void testCheckCartCountAfterAddingOneThing() {
        homePage.search(MOUSE);
        resultPage = new ResultPage(driver);
        mousePage = new MousePage(driver);
        resultPage.isPageLoaded();
        resultPage.clickOnFirstElementMouse();
        mousePage.isPageLoaded();
        mousePage.clickOnAddToCartButton();

        int cartCount = Integer.parseInt(mousePage.getCartCount());
        assertThat(cartCount, equalTo(1));
    }

    @Test(priority = 0)
    public void testChangeLanguageToSpain() {
        homePage.clickOnLanguage();
        languagePage = new LanguagePage(driver);
        languagePage.isPageLoaded();
        String title = languagePage.getTitleAfterChangeLanguageToSpain();

        assertThat(title, containsString(TITLE));
    }

    @Test(priority = 2)
    public void testZeroCartCountAfterDelete(){
        homePage.search(MOUSE);
        resultPage = new ResultPage(driver);
        mousePage = new MousePage(driver);
        resultPage.isPageLoaded();
        resultPage.clickOnFirstElementMouse();
        mousePage.isPageLoaded();
        mousePage.clickOnAddToCartButton();
        mousePage.clickOnCart();
        cartPage = new CartPage(driver);
        cartPage.isPageLoaded();
        cartPage.clickOnDeleteButton();
        int cartCount = Integer.parseInt(mousePage.getCartCount());

        assertThat(cartCount, equalTo(0));
    }

    @AfterTest
    public void cleanUp() {
        driver.close();
    }
}
