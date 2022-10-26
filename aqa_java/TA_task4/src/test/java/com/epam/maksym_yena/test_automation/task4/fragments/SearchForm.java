package com.epam.maksym_yena.test_automation.task4.fragments;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextInput;

@FindBy(xpath = "//div[@id='nav-search']")
public class SearchForm extends HtmlElement {

    @FindBy(xpath = "//input[@id='twotabsearchtextbox']")
    private TextInput search;

    @FindBy(xpath = "//input[@value='Go']")
    private Button submit;

    public void inputTextToSearch(String request) {
        search.clear();
        search.sendKeys(request);
    }

    public void clickSubmitButton() {
        submit.click();
    }
}