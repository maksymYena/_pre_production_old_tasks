package com.epam.maksym_yena.task3_part1.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.List;

public class HomePage extends BasePage {

    private static final String GOOGLE_URL = "https://www.google.com.ua";
    private static final String TARGET_URL = "https://pn.com.ua";
    private static final String TARGET_LANGUAGE = "//ul[@class = 'lang-menu']//a[contains(text(), 'UA')]";
    private static final String PREVIOUS_LANGUAGE = "//ul[@class = 'lang-menu']//a[contains(text(), 'RU')]";
    private static final String LABEL_NAME = "//span[contains(text(), 'Товары и услуги')]";
    private static final String DISPLAYED_ELEMENTS = "//div[@class = 'pc-block']";;

    public static String getGoogleUrl() {
        return GOOGLE_URL;
    }

    public static String getTargetUrl() {
        return TARGET_URL;
    }

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage searchInGoogle() {
        driver.get(GOOGLE_URL);
        driver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).sendKeys(TARGET_URL);
        driver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).sendKeys(Keys.ENTER);
        driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div[1]/a/h3")).click();
        return new HomePage(driver);
    }



    public String findSubstring(String text, int length) {
        if(length >= text.length()) {
            return "";
        }
        else {
            return text.substring(0, length);
        }
    }

    public boolean changeLanguage() {

        String beforeChange = driver.findElement(By.xpath(LABEL_NAME)).getText();
        driver.findElement(By.xpath(TARGET_LANGUAGE)).click();
        driver.findElement(By.xpath(PREVIOUS_LANGUAGE)).click();
        String afterChange = driver.findElement(By.xpath(LABEL_NAME)).getText();

        return beforeChange.equals(afterChange);
    }

    public int checkMenuItemsCount () {

        List<WebElement> elements = driver.findElements(By.xpath(DISPLAYED_ELEMENTS));

        return elements.size();
    }

    public int menuCount() {
        List<String> menuItems = new ArrayList<String>();
        menuItems.add("Компьюторы");
        menuItems.add("Электроника");
        menuItems.add("Бытовая техника");
        menuItems.add("Всё для дома");
        menuItems.add("Мебель");
        menuItems.add("Стройка");
        menuItems.add("Дача, сад, огород");
        menuItems.add("Детские товары");
        menuItems.add("Зоотовары");
        menuItems.add("Спорт");
        menuItems.add("Туризм и рыбалка");
        menuItems.add("Авто");
        menuItems.add("Продукты и алкоголь");
        menuItems.add("Здоровье");

        return menuItems.size();
    }

    public void ReloadPage() {
        driver.navigate().refresh();
    }
}
