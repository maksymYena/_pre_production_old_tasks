package com.epam.maksym_yena.task3_part1.tests;

import com.epam.maksym_yena.task3_part1.pages.HomePage;
import com.epam.maksym_yena.task3_part1.pages.SearchPage;
import org.junit.*;


public class testSearchPage extends AbstractTest{

    @Test
    public void testSearchPage() {
        HomePage homePage = new HomePage(driver);
        homePage.searchInGoogle();
        SearchPage searchPage = new SearchPage(driver);
        searchPage.checkToSearch();

        Assert.assertTrue(driver.getCurrentUrl().contains(homePage.findSubstring("Iphone 11",6)));
    }
}
