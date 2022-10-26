package com.epam.maksym_yena.task3_part1.tests;

import com.epam.maksym_yena.task3_part1.pages.HomePage;
import org.junit.Assert;
import org.junit.Test;

public class testHomePage extends AbstractTest{

    @Test
    public void testLanguageMenu() {
        HomePage homePage = new HomePage(driver);
        homePage.searchInGoogle();

        Assert.assertTrue(homePage.changeLanguage());
    }

    @Test
    public void testCountOfMenuItems() {
        HomePage homePage = new HomePage(driver);
        homePage.searchInGoogle();
        int expected = homePage.menuCount();
        int actual = homePage.checkMenuItemsCount();

        Assert.assertEquals(expected,actual);
    }
}
