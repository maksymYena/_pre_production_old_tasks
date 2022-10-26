package com.epam.maksym_yena.test_automation.task9.business;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;


import static com.codeborne.selenide.Selenide.$;

public class Constant {
    public static final String LOGIN = "invalid123";

    public static final String URL = "https://github.com/";
    public static final SelenideElement EMAIL = $(By.xpath("//input[@id= 'user[login]']"));
    public static final SelenideElement DISPLAY_ERROR = $(By.xpath("//div[@class = 'js-suggested-usernames-container text-gray']"));
    public static final SelenideElement RED_ERROR_SIGH_INSIDE_EMAIL_FORM = $(By.cssSelector("form > auto-check:nth-child(5) > dl > dt > label"));

    public static final String USERNAME = "MaximYena";

    public static final String EMAIL_FIELD = "//input[@id= 'user[login]']";
    public static final String PASSWORD_FIELD = "//input[@id= 'user[password]']";
    public static final String ERRORS_BELOW_EMAIL = "//div[@class = 'mb-1 ']";
    public static final String PASSWORD = "//input[@id= 'user[password]']";

    public static final String CORRECT_LOGIN = "yenamaxim98@gmail.com";

    public static final String ERROR_TEXT_BELLOW_THE_PASSWORD = "form > password-strength > p > span:nth-child(2)";
    public static final String PASSWORD_FIELD_NAME = "form > password-strength > dl > dt > label";

}
