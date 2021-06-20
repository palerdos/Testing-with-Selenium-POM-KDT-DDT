package tests;

import Pages.SeleniumRadioButton;
import Pages.SeleniumTestPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.*;

public class TestSeleniumRadioButton {

    WebDriver driver = new ChromeDriver();

    SeleniumTestPage objTestPage;
    SeleniumRadioButton objRadioButtonPage;

    @BeforeEach
    void setUp() {
        SeleniumTestHelper.setupHelper(driver);
        objTestPage = new SeleniumTestPage(driver);
        objRadioButtonPage = new SeleniumRadioButton(driver);
    }

    @AfterEach
    void tearDown() {
        driver.close();
        driver.quit();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/radioButtonData.csv", numLinesToSkip = 1)
    void groupRadioButtons(String sex, String age, String expected) throws Exception {
        String result = "";
        objTestPage.clickInputFormMenu();
        objTestPage.clickRadioButtonMenu();
        objRadioButtonPage.radioButtonGenderHelper(sex);
        objRadioButtonPage.radioButtonAgeHelper(age);
        objRadioButtonPage.clickGetValuesBtn();
        result += expected;
        System.out.println(result);
        assertEquals(expected, objRadioButtonPage.getDisplayedMessage());
    }

}
