package com.epam.maksym_yena.test_automation.task4.pages;

import com.epam.maksym_yena.test_automation.task4.fragments.SearchForm;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

public class HomePage extends BasePage {

    @FindBy(xpath = "//div[@id='txMzozV5224elGLxydPQQw']")
    private HtmlElement categories;

    @FindBy(xpath = "//span[@class='icp-nav-link-inner']")
    private Button language;

    private SearchForm searchForm;

    public void search(String request) {
        searchForm.inputTextToSearch(request);
        searchForm.clickSubmitButton();
    }

    public void clickOnLanguage(){
        language.click();
    }

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public WebElement getLoadableElement() {
        return categories;
    }

}
