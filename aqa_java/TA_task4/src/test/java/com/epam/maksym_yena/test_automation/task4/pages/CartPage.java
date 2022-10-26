package com.epam.maksym_yena.test_automation.task4.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextBlock;

public class CartPage extends BasePage{

    @FindBy(xpath = "//div[@class='a-container']")
    private HtmlElement filling;

    @FindBy(xpath = "//span[contains(@class, 'sc-product-price a-text-bold')]")
    private TextBlock priceOfOneThing;

    @FindBy(xpath = "//div[@id='sc-buy-box']//span[contains(@class, 'sc-white-space-nowrap')]")
    private TextBlock totalPrice;

    @FindBy(xpath = "//input[@data-action='delete']")
    private Button delete;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public String getPrice(){
        return priceOfOneThing.getText();
    }

    public String getTotalPrice(){
        return totalPrice.getText();
    }

    public void clickOnDeleteButton(){
        delete.click();
    }

    public WebElement getLoadableElement() {
        return filling;
    }
}
