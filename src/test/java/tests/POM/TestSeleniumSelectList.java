package tests.POM;

import Pages.SeleniumSelectList;
import Pages.SeleniumTestPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.*;

public class TestSeleniumSelectList {

    WebDriver driver = new ChromeDriver();

    SeleniumTestPage objTestPage;
    SeleniumSelectList objSelectListPage;

    @BeforeEach
    void setUp() {
        SeleniumTestHelper.setupHelper(driver);
        objTestPage = new SeleniumTestPage(driver);
        objSelectListPage = new SeleniumSelectList(driver);
    }

    @AfterEach
    void tearDown() {
        driver.close();
        driver.quit();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/selectListData.csv", numLinesToSkip = 1)
    void selectDropdownList(String input, String expected) throws Exception {
        objTestPage.clickInputFormMenu();
        objTestPage.clickSelectDropdownListMenu();
        objSelectListPage.selectListHelper(input);
        assertTrue(objSelectListPage.getSelectedMessage(input).contains(input));
    }

}
