package com.epam.maksym_yena.test_automation.task10.pages;

import com.codeborne.selenide.*;
import com.epam.maksym_yena.test_automation.task10.Constant;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.security.Key;

import static com.codeborne.selenide.Browsers.FIREFOX;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;

public class HomePage extends Constant {

    @Given("Gmail page is opened")
    public void openPage() {
        open(URL);
    }

    @When("user enters into email field with currect login and password")
    public void entersIntoAccount()  {
        $(By.id("identifierId")).shouldBe(Condition.enabled).sendKeys(USERNAME, Keys.ENTER);
        $(By.xpath(PASSWORD_FIELD)).sendKeys(PASSWORD, Keys.ENTER);
    }

    @And("Then user can see the main page")
    public void checkTheMainPage() {
        boolean result = $(By.xpath(CREATE_LETTER)).shouldBe(Condition.visible).isDisplayed();
        Assert.assertTrue(result);
    }

    @Then("user log out of email")
    public void logOut() {
        closeWindow();
    }
}
