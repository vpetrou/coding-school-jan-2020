package com.testing.pages;

import com.testing.utils.BaseTest;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Contact extends BaseTest {

    private WebDriver driver;

    @FindBy(name = "name")
    WebElement name;
    @FindBy(name = "email")
    WebElement email;
    @FindBy(name = "city")
    WebElement city;
    @FindBy(xpath = "//button[contains(text(),'Save')]")
    WebElement saveButton;

    @FindBy(css = "h3")
    WebElement pageTitle;

    public Contact(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void verifyContactPageOpens() {
        Assert.assertEquals("Add New Contact", pageTitle.getText());
    }

    public void addNewContact(DataTable dataTable) {
        logger.info("The user adds a new contact.");
        element.input(name, getValue(dataTable, "Name"));
        element.input(email, getValue(dataTable, "Email"));
        element.dropdown(city, getValue(dataTable, "City"));
        saveButton.click();
        waitForLoad();
    }

}
