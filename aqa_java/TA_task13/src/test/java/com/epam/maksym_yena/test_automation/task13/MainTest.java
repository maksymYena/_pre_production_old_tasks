package com.epam.maksym_yena.test_automation.task13;

import com.codeborne.selenide.SelenideElement;
import com.epam.maksym_yena.task13.MainPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.xpath;


public class MainTest extends TestSelenoid {

    private static final SelenideElement INPUT = $(xpath("//input[@name='text']"));

    @Test
    public void testName() throws InterruptedException {
        MainPage.open();
        Thread.sleep(5000);
        INPUT.shouldHave(appear).setValue("text");
        Thread.sleep(5000);
    }
}