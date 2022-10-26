package com.epam.maksym_yena.test_automation.task4.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;


public abstract class BasePage implements Page {

    protected String PAGE_URL = "https://www.amazon.com/";
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new HtmlElementDecorator(new HtmlElementLocatorFactory(driver)), this);
    }

    public boolean isPageLoaded() {
        return getLoadableElement().isDisplayed();
    }

    public void openPage() {
        driver.get(PAGE_URL);
    }

}
