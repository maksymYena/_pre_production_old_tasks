package com.epam.maksym_yena.task3_part1.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUpPage extends BasePage {

    private static final String SIGN_IN_WINDOW = "//div[@class = 'popup-content']";
    private static final String CREATING_ACCOUNT = "//a[contains(text(), 'Зарегистрируйтесь')]";
    private static final String ENTER_TO_REGISTRATION = "//span[contains(text(), 'Войти')]";
    private static final String POP_UP_REGISTRATION_WINDOW = "//div[contains(text(), 'Регистрация на сайте')]";
    private static final String USER_NAME = "//span[contains(text(), 'lafer123')]";
    private static final String USERS_ACCOUNT_WINDOW = "//ul[@id = 'userSettings']";
    private static final String PASSWORD = "1998113";
    private static final String LOGIN = "lafer123@yandex.ru";


    public  String getPASSWORD() {
        return PASSWORD;
    }

    public  String getLOGIN() {
        return LOGIN;
    }

    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[contains(text(), 'Войти')]")
    private WebElement enter;

    @FindBy(xpath = "//input[@id = 'login-form-login']")
    private WebElement email;

    @FindBy(xpath =  "//input[@id = 'login-form-password']")
    private WebElement password;

    @FindBy(xpath =  "//button[@id = 'loginButton']")
    private WebElement button;

    @FindBy(xpath = "//*[@id=\"register-form-email\"]")
    private WebElement creatingAccount_email;

    @FindBy(xpath = "//input[@id = 'register-form-password']")
    private WebElement creatingAccount_password;

    @FindBy(xpath = "//input[@id = 'register-form-password_repeat']")
    private WebElement creatingAccount_password_repeated;

    @FindBy(xpath = "//button[contains(text(), 'Зарегистрироваться')]")
    private WebElement button_create;



    public String LogIn() {
        WebDriverWait webDriverWait = new WebDriverWait(driver,1);
        driver.findElement(By.xpath(ENTER_TO_REGISTRATION)).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SIGN_IN_WINDOW)));

        this.email.click();
        this.email.sendKeys(LOGIN);
        this.password.click();
        this.password.sendKeys(PASSWORD);
        this.button.click();

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(USER_NAME)));
        driver.findElement(By.xpath(USER_NAME)).click();

        String text =  driver.findElement(By.xpath(USER_NAME)).getText();

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(USERS_ACCOUNT_WINDOW)));
        driver.findElement(By.xpath(USERS_ACCOUNT_WINDOW)).click();

        return text;
    }

    public void createAccount() {

        WebDriverWait webDriverWait = new WebDriverWait(driver,1);
        driver.findElement(By.xpath(ENTER_TO_REGISTRATION)).click();

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SIGN_IN_WINDOW)));
        driver.findElement(By.xpath(CREATING_ACCOUNT)).click();

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(POP_UP_REGISTRATION_WINDOW)));

        creatingAccount_email.click();
        creatingAccount_email.sendKeys(LOGIN);
        creatingAccount_password.click();
        creatingAccount_password.sendKeys(PASSWORD);
        creatingAccount_password_repeated.click();
        creatingAccount_password_repeated.sendKeys(PASSWORD);
        button_create.click();
    }
}
