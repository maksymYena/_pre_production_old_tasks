package com.epam.maksym_yena.test_automation.task4.pages;


import com.epam.maksym_yena.test_automation.task4.fragments.CartForm;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextBlock;

public class MousePage extends BasePage {

    @FindBy(xpath = "//div[@id='dp']")
    private HtmlElement filling;

    @FindBy(xpath = "//input[@id='add-to-cart-button']")
    private Button addToCart;

    private CartForm cartForm;

    public MousePage(WebDriver driver) {
        super(driver);
    }

    public void clickOnAddToCartButton() {
        addToCart.click();
    }

    public String getCartCount() {
        return cartForm.getCartCount();
    }

    public void clickOnCart(){
        cartForm.clickOnCart();
    }

    public WebElement getLoadableElement() {
        return filling;
    }
}
