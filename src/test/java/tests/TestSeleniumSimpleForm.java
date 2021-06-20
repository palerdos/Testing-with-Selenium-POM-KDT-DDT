package tests;

import Pages.SeleniumSimpleForm;
import Pages.SeleniumTestPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.*;

public class TestSeleniumSimpleForm {

    WebDriver driver = new ChromeDriver();

    SeleniumSimpleForm objSimpleFormPage;
    SeleniumTestPage objTestPage;

    @BeforeEach
    void setUp() {
        SeleniumTestHelper.setupHelper(driver);
        objSimpleFormPage = new SeleniumSimpleForm(driver);
        objTestPage = new SeleniumTestPage(driver);
    }

    @AfterEach
    void tearDown() {
        driver.close();
        driver.quit();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/singleFieldData.csv", numLinesToSkip = 1)
    void singleFieldAndButton(String input, String expected) {
        objTestPage.clickInputFormMenu();
        objTestPage.clickSimpleFormMenu();
        objSimpleFormPage.enterInputMessage(input);
        objSimpleFormPage.clickOnShowMessage();
        assertEquals(expected, objSimpleFormPage.getDisplayedMessage());
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/twoFieldData.csv", numLinesToSkip = 1)
    void twoFieldsAndOutput(String aInput, String bInput, String expected) {
        objTestPage.clickInputFormMenu();
        objTestPage.clickSimpleFormMenu();
        objSimpleFormPage.enterInputFieldAMessage(aInput);
        objSimpleFormPage.enterInputFieldBMessage(bInput);
        objSimpleFormPage.clickOnGetTotalBtn();
        assertEquals(expected, objSimpleFormPage.getTwoInputFieldResult());
    }

}
