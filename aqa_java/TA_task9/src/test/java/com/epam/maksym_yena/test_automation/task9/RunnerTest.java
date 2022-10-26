package com.epam.maksym_yena.test_automation.task9;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

import static com.codeborne.selenide.Selenide.open;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/"
)
public class RunnerTest {

}
