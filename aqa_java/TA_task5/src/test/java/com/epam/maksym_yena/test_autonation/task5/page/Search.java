package com.epam.maksym_yena.test_autonation.task5.page;

import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.screenshot;

public final class Search {

    private Search() {
        throw new IllegalStateException("This is Page Object class");
    }

    public static String GOOGLE_URL = "https://www.google.com/";

    private static String SELENIDE_LINQ = "//h3[contains(text(), 'Selenide: лаконичные и стабильные UI тесты на Java')]";

    private static String TARGET_URL = "https://ru.selenide.org/";

    private static String SELENIDE = "Selenide";

    private static By search = By.xpath("//input[@name = 'q']");

    public static void searchInGoogle() {
        $(search).sendKeys(SELENIDE, Keys.ENTER);
    }

    public static void clickOnTheFirstLinq() {
        $(By.xpath(SELENIDE_LINQ)).click();
    }

    public static String getCurrentURL() {
        return WebDriverRunner.url();
    }

    public static void makeScreenShot() {
        screenshot("my_file_name");
    }
    
    public static boolean isEquals(String ling) {
        return ling.equals(TARGET_URL);
    }
}
