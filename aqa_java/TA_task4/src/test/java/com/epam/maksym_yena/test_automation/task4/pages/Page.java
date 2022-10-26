package com.epam.maksym_yena.test_automation.task4.pages;

import org.openqa.selenium.WebElement;

public interface Page {

    boolean isPageLoaded();

    void openPage();

    WebElement getLoadableElement();

}
