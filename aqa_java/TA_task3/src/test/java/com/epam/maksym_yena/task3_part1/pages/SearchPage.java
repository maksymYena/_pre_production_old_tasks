package com.epam.maksym_yena.task3_part1.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage {

    private static final String IPHONE_11 = "Iphone 11";

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@class = 'search-text-input']")
    private WebElement input;

    @FindBy(xpath = "//div[@class = 'search-group-submit']")
    private WebElement buttonFind;

    public String checkToSearch() {
        this.input.click();
        this.input.sendKeys(IPHONE_11);
        this.buttonFind.click();
        return driver.getCurrentUrl();
    }


}
