package com.epam.maksym_yena.test_automation.task8;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;
import static com.epam.maksym_yena.test_automation.task8.CONSTANT.*;


public class testHomeAlloPage {


    @DataProvider(name = "header-links")
    public static Object[][] credentials() {
        return new Object[][]{
                {"Блог", 0},
                {"Fishka", 1},
                {"Вакансии", 2},
                {"Магазины", 3},
                {"Доставка и оплата", 4},
                {"Кредит", 5},
                {"Гарантия / Возврат", 6},
                {"Контакты", 7},
        };
    }

    @BeforeClass
    public void setUp() {
        open(URL);
    }

    @Test(dataProvider = "header-links")
    public void testHeaderLinksName(String data, Integer currentValue) {
       ElementsCollection collections = $$(By.xpath(HEADER_LINK));

       Assert.assertTrue(collections.get(currentValue).getText().equals(data));
    }

    @Test(singleThreaded = true)
    public void testCheckFind() throws InterruptedException {
        $(INPUT).sendKeys("Iphone 7", Keys.ENTER);
        $(MENU_ON_THE_PAGE).shouldBe(Condition.enabled);

        Assert.assertTrue(url().equals(TARGET_URL));
    }

    @AfterClass
    public void cleanUp() {
        System.out.println("Congratulation! All tests were finished!");
    }

}
