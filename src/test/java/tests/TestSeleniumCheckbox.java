package tests;

import Pages.SeleniumCheckbox;
import Pages.SeleniumTestPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.*;

public class TestSeleniumCheckbox {

    WebDriver driver = new ChromeDriver();

    SeleniumTestPage objTestPage;
    SeleniumCheckbox objCheckboxPage;

    @BeforeEach
    void setUp() {
        SeleniumTestHelper.setupHelper(driver);
        objTestPage = new SeleniumTestPage(driver);
        objCheckboxPage = new SeleniumCheckbox(driver);
    }

    @AfterEach
    void tearDown() {
        driver.close();
        driver.quit();
    }

    @Test
    void singleCheckBox() {
        objTestPage.clickInputFormMenu();
        objTestPage.clickCheckboxMenu();
        objCheckboxPage.clickOnSingleCheckbox();
        assertTrue(objCheckboxPage.singleCheckboxIsSelected());
    }
}
