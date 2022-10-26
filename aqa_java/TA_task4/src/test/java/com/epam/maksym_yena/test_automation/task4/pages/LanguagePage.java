package com.epam.maksym_yena.test_automation.task4.pages;

import com.epam.maksym_yena.test_automation.task4.fragments.LanguageForm;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

public class LanguagePage extends BasePage {

    private LanguageForm languageForm;

    @FindBy(xpath = "//form[@method='post']")
    private HtmlElement filling;

    public LanguagePage(WebDriver driver) {
        super(driver);
    }

    public String getTitleAfterChangeLanguageToSpain() {
        languageForm.clickOnSpainLanguage();
        return languageForm.getTitle();
    }

    public WebElement getLoadableElement() {
        return filling;
    }
}
