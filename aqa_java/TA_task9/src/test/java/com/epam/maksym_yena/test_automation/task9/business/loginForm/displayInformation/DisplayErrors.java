package com.epam.maksym_yena.test_automation.task9.business.loginForm.displayInformation;

import com.codeborne.selenide.Condition;
import com.epam.maksym_yena.test_automation.task9.business.Constant;
import cucumber.api.java.cs.A;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.xpath;

public class DisplayErrors extends Constant {

    @And("error message below email field should be displayed")
    public void checkDisplayedErrorMessageBelowEmailField() {
        String text = $(DISPLAY_ERROR).shouldBe(Condition.enabled).getText();
        if(text.length() > LOGIN.length()) {
            Assert.assertTrue(true);
        }
        else {
            Assert.fail();
        }
    }

    @Then("“at least 15 characters” message should be marked red")
    public void checkMarkedFifteenCharactersShouldBeRed() {
        $(By.cssSelector(ERROR_TEXT_BELLOW_THE_PASSWORD)).shouldBe(Condition.visible);
        String color = $(By.cssSelector(ERROR_TEXT_BELLOW_THE_PASSWORD)).getCssValue("color").substring(5,7);

        int redValue = Integer.parseInt(color);
        boolean result = redValue > 19;

        Assert.assertTrue(result);
    }

    @And("“a lowercase letter” message should be marked green")
    public void checkTheLowerCaseLatterMessageShouldBeMarkedGreen() {
        String color = $(By.cssSelector(ERROR_TEXT_BELLOW_THE_PASSWORD)).getCssValue("color").substring(5,7);
        int redValue = Integer.parseInt(color);
        boolean result = redValue > 30;
        Assert.assertTrue(result);
    }

    @Then("red error sign inside the email field should be displayed")
    public void checkRedErrorsInsideTheEmailField() {
        String getText = $(DISPLAY_ERROR).shouldBe(Condition.enabled).getText();
        boolean isResult = getText.length() > LOGIN.length();
        Assert.assertTrue(isResult);
    }

    @And("“a lowercase letter” message should be marked red")
    public void checkTheLowerCaseLatterMessageShouldBeMarkedRed()  {
        $(By.cssSelector(PASSWORD_FIELD_NAME)).shouldBe(Condition.enabled);
        String color = $(By.cssSelector(PASSWORD_FIELD_NAME)).getCssValue("color").substring(5,7);
        int redValue = Integer.parseInt(color);
        boolean result = redValue > 30;
        Assert.assertTrue(result);
    }

    @And("error message below username field should be displayed")
    public void checkMarkedSymbolsOnGreen() {
        $(xpath(ERRORS_BELOW_EMAIL)).shouldBe(Condition.enabled);
    }

    @And("suggested usernames in error message contains the username entered")
    public void checkContainsUsernameIntoErrorMessage() {
        $(xpath(ERRORS_BELOW_EMAIL)).shouldBe(Condition.enabled);
        String errorMess =  $(xpath(ERRORS_BELOW_EMAIL)).getText();
        boolean isResult = errorMess.contains(USERNAME);
        Assert.assertTrue(isResult);
    }
}


