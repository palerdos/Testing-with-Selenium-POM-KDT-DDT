package tests;

import Pages.SeleniumCheckbox;
import Pages.SeleniumTestPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

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

    @ParameterizedTest
    @CsvFileSource(resources = "/multipleCheckboxData.csv", numLinesToSkip = 1)
    void multipleCheckboxes(String single, String first, String second, String third, String fourth, String expected) {
        objTestPage.clickInputFormMenu();
        objTestPage.clickCheckboxMenu();
        if (single.equals("1")) {
            objCheckboxPage.clickOnSingleCheckbox();
        } else if (first.equals("1")) {
            objCheckboxPage.clickOnFirstCheckbox();
        } else if (second.equals("1")) {
            objCheckboxPage.clickOnSecondCheckbox();
        } else if (third.equals("1")) {
            objCheckboxPage.clickOnThirdCheckbox();
        } else if (fourth.equals("1")) {
            objCheckboxPage.clickOnFourthCheckbox();
        }
        assertEquals(expected, objCheckboxPage.getCheckBtnValue());
    }
}
