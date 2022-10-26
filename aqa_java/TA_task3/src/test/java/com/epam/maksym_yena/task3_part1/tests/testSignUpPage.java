package com.epam.maksym_yena.task3_part1.tests;

import com.epam.maksym_yena.task3_part1.pages.HomePage;
import com.epam.maksym_yena.task3_part1.pages.SignUpPage;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;


public class testSignUpPage extends AbstractTest{

    private static final String CHECK_NICKNAME = "/html/body/div[1]/div/header/div/div[2]/div[2]/nav/ul/li[4]/span/a/span";

    @Test
    public void testLogIn() {
        HomePage homePage = new HomePage(driver);
        homePage.searchInGoogle();
        SignUpPage signUpPage = new SignUpPage(driver);
        String text = signUpPage.LogIn();

        Assert.assertTrue(text.equals(homePage.findSubstring(signUpPage.getLOGIN(),8)));
    }

    @Test
    public void testCreateAccount() {
        HomePage homePage = new HomePage(driver);
        homePage.searchInGoogle();
        SignUpPage signUpPage = new SignUpPage(driver);

        signUpPage.createAccount();

        Assert.assertTrue(driver.findElement(By.xpath(CHECK_NICKNAME))
                .getText()
                .contains(homePage.findSubstring(driver.findElement(By.xpath(CHECK_NICKNAME)).getText(),10)));
    }
}
