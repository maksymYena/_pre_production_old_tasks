package com.epam.maksym_yena.task3_part1.tests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AbstractTest {
    protected WebDriver driver;

    @Before
    public void setUp() {
        this.driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @After
    public  void after()  {
        driver.close();
    }
}
