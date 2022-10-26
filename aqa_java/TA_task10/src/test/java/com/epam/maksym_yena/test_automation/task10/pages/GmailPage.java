package com.epam.maksym_yena.test_automation.task10.pages;

import com.codeborne.selenide.Condition;
import com.epam.maksym_yena.test_automation.task10.Constant;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.Keys.CONTROL;
import static org.openqa.selenium.Keys.ENTER;

public class GmailPage extends Constant {

    @Then("user pick button Написать")
    public void writeLetter() {
        $(By.xpath(CREATE_LETTER)).click();
    }

    @And("user filling subject of the letter and send email")
        public void fillingTheLetter() {
        $(By.xpath(MAX_WINDOW)).click();
        $(By.xpath(SUBJECT_OF_LETTER)).sendKeys(USERNAME, CONTROL, ENTER);
        $(By.xpath(ERROR_BUTTON)).shouldBe(Condition.enabled);
    }

    @And("user should be see the message error")
    public void checkDisplayError() {
        boolean isExist = $(By.xpath(ERROR_BUTTON)).shouldBe(Condition.visible).isDisplayed();
        Assert.assertTrue(isExist);
    }
}
