package com.ua.maksym_yema.test_automation.task6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import java.util.concurrent.TimeUnit;
import static com.ua.maksym_yema.test_automation.task6.Constant.*;
import static org.testng.Assert.assertEquals;

public class TestNG {

    private WebDriver driver;

    @BeforeSuite
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        System.out.println("The setup process is completed");
    }

    @BeforeTest
    public void profileSetup() {
        driver.manage().window().maximize();
        System.out.println("The profile setup process is completed");
    }

    @BeforeClass
    public void appSetup() {
        driver.get(URL);
        System.out.println("The app setup process is completed");
    }

    @BeforeMethod
    public void checkLogin() {
        driver.get(LOGIN_URL);

        driver.findElement(By.xpath(INPUT_LOGIN_FORM)).sendKeys(LOGIN);
        driver.findElement(By.xpath(INPUT_PASS_FORM)).sendKeys(PASSWORD);
        driver.findElement(By.xpath(BUTTON_ON_THE_FORM)).click();
        System.out.println("The login process on lamdatest is completed");
    }

    @Test(groups = "urlValidation")
    public void testCurrentUrl() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id='app']/header/aside/ul/li[4]/a")).click();
        Thread.sleep(6000);
        String currentUrl = driver.getCurrentUrl();
        assertEquals(currentUrl, "https://automation.lambdatest.com/timeline/?viewType=build&page=1", "url did not matched");
        System.out.println("The url validation test is completed");
    }


    @AfterClass
    public void closeUp() {
        driver.close();
        System.out.println("The close_up process is completed");
    }

    @AfterSuite
    public void cleanUp() {
        System.out.println("All close up activities completed");
    }

    @BeforeGroups("urlValidation")
    public void setUpSecurity() {
        System.out.println("url validation test starting");
    }

    @AfterGroups("urlValidation")
    public void tearDownSecurity() {
        System.out.println("url validation test finished");
    }
}	