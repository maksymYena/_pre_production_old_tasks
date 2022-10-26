package com.epam.maksym_yena.task_1;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstTest {

    private static final String GOOGLE_URL = "http://www.google.com";
    private static final String SEARCH = "selenium";
    private static final String SELENIUM_LINK = "//a[@href = 'https://www.selenium.dev/']";
    private static final String GOOGLE_SEARCH = "q";

    private WebDriver webDriver;

    @Before
    public void setUp()  {
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
    }

    @Test
    public void checkSeleniumPage() {

        boolean condition;

        webDriver.get(GOOGLE_URL);

        WebElement element = webDriver.findElement(By.name(GOOGLE_SEARCH));

        element.sendKeys(SEARCH);
        element.sendKeys(Keys.ENTER);

        element = webDriver.findElement(By.xpath(SELENIUM_LINK));
        element.click();

        String currentUrl = webDriver.getCurrentUrl();

        condition = currentUrl.contains(SEARCH);
        Assert.assertTrue(condition);
    }

    @After
    public void cleanObject() {
        webDriver = null;
    }
}
