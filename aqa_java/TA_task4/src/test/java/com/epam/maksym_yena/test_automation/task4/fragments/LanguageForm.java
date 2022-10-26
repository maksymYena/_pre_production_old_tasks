package com.epam.maksym_yena.test_automation.task4.fragments;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextBlock;

@FindBy(xpath = "//form[@method='post']")
public class LanguageForm extends HtmlElement {

    @FindBy(xpath = "//span[@id='lop-heading']")
    private TextBlock title;

    @FindBy(xpath = "//input[@value='es_US']/following-sibling::i")
    private Button spainLanguage;

    public void clickOnSpainLanguage() {
        spainLanguage.click();
    }

    public String getTitle() {
        return title.getText();
    }
}
