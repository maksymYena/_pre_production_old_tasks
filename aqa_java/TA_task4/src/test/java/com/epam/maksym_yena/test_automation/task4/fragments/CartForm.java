package com.epam.maksym_yena.test_automation.task4.fragments;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextBlock;

@FindBy(xpath = "//a[@id='nav-cart']")
public class CartForm extends HtmlElement {

    @FindBy(xpath = "//span[@id='nav-cart-count']")
    private TextBlock cartCount;

    @FindBy(xpath = "//a[@id='nav-cart']")
    private Button cartButton;

    public String getCartCount() {
        return cartCount.getText();
    }

    public void clickOnCart(){
        cartButton.click();
    }


}
