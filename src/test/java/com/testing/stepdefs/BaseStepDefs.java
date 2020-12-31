package com.testing.stepdefs;

import com.testing.utils.BaseTest;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.logging.Logger;

public class BaseStepDefs extends BaseTest {

    @Before("@UI")
    public void setup() {
        openBrowser();
    }

    @After(value = "@UI", order = 0)
    public void tearDown() {
        closeBrowser();
    }

    @Given("the Demo Application is opened")
    public void the_Demo_Application_is_opened() {
        openApplication();
    }

    @When("the user navigates to {string} page")
    public void the_user_navigates_to_page(String pageName) {
        menu.navigateToPage(pageName);
    }

    @After(value = "@TC-UI-CON-001", order = 1)
    public void AFTER_TC_UI_CON_001() {
        cleanupContact();
    }

}
