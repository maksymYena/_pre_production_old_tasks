package com.epam.maksym_yena.test_automation.task9.business.loginForm.formFilling;

import com.codeborne.selenide.Condition;
import com.epam.maksym_yena.test_automation.task9.business.Constant;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.xpath;

public class FillingTheForm extends Constant {

    @When("user enters “invalid123” into email field")
    public void enterEmail() {
        $(EMAIL).click();
        EMAIL.setValue("invalid123");
    }

    @When("user enters “AAA” into password field")
    public void inputPassword() {
        $(By.xpath(PASSWORD_FIELD)).click();
        $(By.xpath(PASSWORD_FIELD)).sendKeys("AAA", Keys.ENTER);

    }

    @When("user enters “AAAaaa” into password field")
    public void inputCorrectPassword() {
        $(By.xpath(PASSWORD)).sendKeys("AAAaaa", Keys.ENTER);
    }

    @Then("red error sign inside username field should be displayed")
    public void checkRedSymbolsIntoUsername() {
        $(xpath(ERRORS_BELOW_EMAIL)).shouldBe(Condition.enabled);
    }

    @When("user enters already existent username into username field")
    public void enterExistentUsernameInUsernameField() {
        $(xpath(EMAIL_FIELD)).sendKeys(USERNAME);
        $(xpath(ERRORS_BELOW_EMAIL)).shouldBe(Condition.enabled);
    }
}
