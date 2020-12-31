package com.testing.utils;

import com.testing.pages.Contact;
import com.testing.pages.ContactList;
import com.testing.pages.Menu;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.logging.Logger;

public class BaseTest {

    public Logger logger = Logger.getGlobal();

    WebDriver driver;
    public static WebDriverWait wait;
    public static String NEW_CONTACT;

    public static Element element;

    public static ContactList contactList;
    public static Contact contact;
    public static Menu menu;

    public void openBrowser() {
        System.setProperty("webdriver.chrome.driver", getAbsolutePath() + "/src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 30);

        element = new Element(driver);

        contactList = new ContactList(driver);
        contact = new Contact(driver);
        menu = new Menu(driver);
    }

    public void closeBrowser() {
        driver.quit();
    }

    public void openApplication() {
        logger.info("Demo Application is opened.");
        String PROTOCOL = System.getProperty("protocol");
        String HOST = System.getProperty("host");
        String PORT = System.getProperty("port");
        if (PROTOCOL == null || PROTOCOL.isEmpty()) {
            driver.get("http://localhost:7001");
        } else {
            driver.get(PROTOCOL + "://" + HOST + ":" + PORT);
        }
        driver.get("http://localhost:7001");
        waitForLoad();
        Assert.assertEquals("Contact List", driver.findElement(By.cssSelector("h3")).getText());
    }

    public void cleanupContact() {
        driver.findElement(By.xpath("//tr[contains(.,'" + NEW_CONTACT + "')]//a[text()='Details']")).click();
        waitForLoad();
        driver.findElement(By.xpath("//button[text()='Delete']")).click();
        driver.switchTo().alert().accept();
        driver.switchTo().defaultContent();
        waitForLoad();
    }


    public void waitForLoad() {
        ExpectedCondition<Boolean> expectation = driver -> ((JavascriptExecutor) driver)
                .executeScript("return document.readyState").toString().equals("complete");
        try {
            Thread.sleep(500);
            wait.until(expectation);
        } catch (Throwable error) {
            Assert.fail("Timeout waiting for Page Load Request to complete.");
        }
    }

    /*
     * |Label |Label2|
     * |Value |Value2|
     *
     * returns the value under every label
     */

    public String getValue(DataTable dTable, String label) {
        List<List<String>> rows = dTable.asLists();
        int column = getColumn(dTable, label);
        if (column >= 0) {
            return rows.get(1).get(column);
        } else
            return null;
    }

    private int getColumn(DataTable dTable, String label) {
        int column = 0;
        int k = 0;
        boolean flagNotFound = true;
        List<List<String>> rows = dTable.asLists();
        for (List<String> cell : rows) {
            for (int i = 0; i < cell.size(); i++) {
                if (rows.get(k).get(i).equalsIgnoreCase(label)) {
                    column = i;
                    flagNotFound = false;
                    break;
                }
            }
            k++;
        }
        if (flagNotFound) column = -1;
        return column;
    }

    private String getAbsolutePath() {
        return System.getProperty("user.dir");
    }

}
