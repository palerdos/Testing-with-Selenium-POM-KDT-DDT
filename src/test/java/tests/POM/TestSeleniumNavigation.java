package tests.POM;

import Pages.SeleniumTestPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.*;

public class TestSeleniumNavigation {

    WebDriver driver = new ChromeDriver();

    SeleniumTestPage objTestPage;

    @BeforeEach
    void setUp() {
        SeleniumTestHelper.setupHelper(driver);
        objTestPage = new SeleniumTestPage(driver);
    }

    @AfterEach
    void tearDown() {
        driver.close();
        driver.quit();
    }

    @Test
    void navigation() {
        objTestPage.clickInputFormMenu();
        objTestPage.clickSimpleFormMenu();
        assertEquals("https://www.seleniumeasy.com/test/basic-first-form-demo.html", objTestPage.getURL());
    }
}
