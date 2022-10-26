package com.epam.maksym_yena.test_automation.task4.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextBlock;

public class ResultPage extends BasePage {

    @FindBy(xpath = "//span[contains(text(), 'Wooden Wind')]")
    private TextBlock titleOfFirstMobileElement;

    @FindBy(xpath = "//div[@class='a-section a-spacing-none s-shopping-adviser']")
    private HtmlElement filling;

    @FindBy(xpath = "//div[@data-asin='B005EJH6RW']//div[contains(@class,'aok-relative')]")
    private HtmlElement firstElementMouse;


    public ResultPage(WebDriver driver) {
        super(driver);
    }

    public String getTitleOfFirstElement() {
        return titleOfFirstMobileElement.getText();
    }

    public void clickOnFirstElementMouse() {
        firstElementMouse.click();
    }

    public WebElement getLoadableElement() {
        return filling;
    }
}
