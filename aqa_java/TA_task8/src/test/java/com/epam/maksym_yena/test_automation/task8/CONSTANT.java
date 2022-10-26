package com.epam.maksym_yena.test_automation.task8;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.xpath;

public class CONSTANT {
    public static String HEADER_LINK = "//ul[@class = 'header-links']//li";
    public static String URL = "https://allo.ua/ru/";
    public static SelenideElement INPUT = $(xpath("//input[@id = 'search-form__input']"));
    public static SelenideElement MENU_ON_THE_PAGE = $(xpath("//div[@class = 'accordion filter__popular accordion__active']"));
    public static String TARGET_URL = "https://allo.ua/ru/catalogsearch/result/?q=Iphone%207";
}
