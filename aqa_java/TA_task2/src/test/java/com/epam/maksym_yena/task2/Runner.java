package com.epam.maksym_yena.task2;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Runner {

    private  static WebDriver driver;
    private static WebElement element;

    private static final String URL = "https://allo.ua/ru/";
    private static final String URL_ROF_BUYING_PHONE = "https://allo.ua/ru/catalogsearch/result/?q=lg%20g8";

    private static final String FIND_WORLD = "lg";
    private static final String TITLE = "Характеристики";
    private static final int PRICE_FOR_ONE_LG_G8_THINQ = 9450;

    private static final String SWITCHED_THEME = "//div[@class = 'header-theme']//div[@class = 'switcher-toggle']";
    private static final String LIGHT_THEME = "//div[@class = 'header-theme']//div[@class = 'draggable']";
    private static final String INPUT_FORM = "//input[@class = 'search-form__input']";
    private static final String FIRST_PRODUCT = "//li[@class = 'search-models__items']/a[@title= 'lg g8']";
    private static final String MENU_ELEMENTS = "//li[@class ='allo-programs__item']";
    private static final String CLICK_ON_THE_FIRST_PHONE = "//*[@id=\"tns1-item0\"]/picture/img";
    private static final String CHECK_HEADER_OF_TITLE = "//h1[@class = 'product-header__title']";
    private static final String ALL_HEADERS_PRODUCT_PAGE = "//h2[@class = 'product-tab-label__title']";

    private static final String ADD_TO_CART = "//*[@id=\"__layout\"]/div/div[2]/div[1]/div[2]/div[2]/div[3]/div[1]/div/div[3]/div[2]/button";
    private static final String ON_BUY_BUTTON = "//button[@class = 'order-now']";
    private static final String FIND_SUMMARY_ON_THE_BUYING_PAGE = "//p[@class = 'total-box']";
    private static final String CLOSE_THE_MODAL_POP_UP_WINDOW = "//div[@class = 'v-modal__close-btn']";
    private static final String SHOPPING_CART = "//div[@class ='shopping-cart__mobile-click']";
    private static final String TOTAL_PRICE = "//span[@class = 'total-box__price']";

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void checkThemeSwitch() {
        boolean result;
        driver.get(URL);
        driver.manage().window().maximize();
        driver.findElement(By.xpath(SWITCHED_THEME)).click();
        element = driver.findElement(By.xpath(LIGHT_THEME));

        result = element.isDisplayed();

        Assert.assertTrue(result);
    }

    @Test
    public void checkPopWindowsElements() {
        driver.get(URL);

        element = driver.findElement(By.xpath(INPUT_FORM));
        element.click();
        element.sendKeys(FIND_WORLD);

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        element.findElement(By.xpath(FIRST_PRODUCT)).click();

        driver.navigate().refresh();

        String currentURL = driver.getCurrentUrl();

        boolean isResult = currentURL.contains(FIND_WORLD);
        Assert.assertTrue(isResult);
    }

    @Test
    public void checkMenuNamed() {
        int counter = 0;
        List<String> menuName = new ArrayList<String>();
        menuName.add("Живи Смарт");
        menuName.add("Алло-Гроші");
        menuName.add("Алло-Обмен");
        menuName.add("Уценка");
        menuName.add("Акции");

        driver.get(URL);
        driver.manage().window().maximize();
        List<WebElement> elements = driver.findElements(By.xpath(MENU_ELEMENTS));
        for(int i = 0; i < elements.size(); i++) {
                if (elements.get(i).getText().equals(menuName.get(i))) {
                    counter++;
                }
        }
        if(counter != menuName.size()) {
            Assert.fail();
        }
        else {
            Assert.assertTrue(true);
        }
    }

    @Test
    public void checkDescriptionTheFirstPhone() {
        int counter = 0;
        String expectedNameOfHeader = "LG G8 ThinQ 6/128GB Black";

        driver.get(URL);

        driver.manage().window().maximize();

        element = driver.findElement(By.xpath(INPUT_FORM));
        element.click();
        element.sendKeys(FIND_WORLD);

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        element.findElement(By.xpath(FIRST_PRODUCT)).click();

        driver.navigate().refresh();
        driver.findElement(By.xpath(CLICK_ON_THE_FIRST_PHONE)).click();

        String titleName = driver.findElement(By.xpath(CHECK_HEADER_OF_TITLE)).getText();

        if(titleName.equals(expectedNameOfHeader)) {
            counter++;
        }

        List<WebElement> elementsValue = driver.findElements(By.xpath(ALL_HEADERS_PRODUCT_PAGE));

        for(int i = 0; i < elementsValue.size(); i++) {
            if(elementsValue.get(i).getText().contains(TITLE)) {
                counter++;
                elementsValue.get(i).click();
                break;
            }
        }
       Assert.assertEquals(2,counter);
    }


    @Test
    public void checkBuyingPhone() {
        String createOrder = "Оформить заказ";

        driver.get(URL_ROF_BUYING_PHONE);

        driver.manage().window().maximize();

        element = driver.findElement(By.xpath(ADD_TO_CART));
        element.click();

        WebDriverWait webDriverWait = new WebDriverWait(driver,10);

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ON_BUY_BUTTON)));

        element = driver.findElement(By.xpath(ON_BUY_BUTTON));

        String title = element.getText();

        if(!title.equals(createOrder)) {
            Assert.fail();
        }

        element = driver.findElement(By.xpath(FIND_SUMMARY_ON_THE_BUYING_PAGE));

        String price = element.getText().replace(" ","").substring(0,4);
        if(!price.contains(price)) {
            Assert.fail();
        }
        Assert.assertTrue(true);
    }

    @Test
    public void checkProductCart() {
        driver.get(URL_ROF_BUYING_PHONE);
        driver.manage().window().maximize();

        element = driver.findElement(By.xpath(ADD_TO_CART));
        element.click();

        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ON_BUY_BUTTON)));
        element = driver.findElement(By.xpath(CLOSE_THE_MODAL_POP_UP_WINDOW));
        element.click();

        //CLICK ON THE SHOPPING CART
        element = driver.findElement(By.xpath(SHOPPING_CART));
        element.click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ON_BUY_BUTTON)));

        //check count of products
        element = driver.findElement(By.xpath(TOTAL_PRICE));
        String result = element.getText().replace(" ", "").substring(0, 4);

        int expectedCondition = 1;
        int actualCondition = 1;
        if((Integer.parseInt(result) / PRICE_FOR_ONE_LG_G8_THINQ) != 1) {
            actualCondition = 0;
        }
        Assert.assertEquals(expectedCondition, actualCondition);
    }

    @AfterClass
    public static void afterClass() {
        driver.quit();
    }
}
