package tests;

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
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        driver.manage().window().maximize();
        driver.get("https://www.seleniumeasy.com/test/");
        objTestPage = new SeleniumTestPage(driver);
        objTestPage.waitForAdClickable(driver);
        objTestPage.clickAdCloseBtn();
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
