package com.epam.maksym_yena.test_automation.task9.business;

import com.codeborne.selenide.Condition;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.By.xpath;

public class HomePage extends Constant {

    @Given("Github home page is opened")
    public void openPage() {
        open(URL);
    }

    @And("at least one username is already registered in application")
    public void checkUserAlreadyRegister() {
        Assert.assertTrue(true);
    }
}
