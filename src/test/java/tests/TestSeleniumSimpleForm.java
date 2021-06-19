package tests;

import Pages.SeleniumSimpleForm;
import Pages.SeleniumTestPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestSeleniumSimpleForm {

    WebDriver driver = new ChromeDriver();

    SeleniumSimpleForm objTestPage;

    @BeforeEach
    void setUp() {
        SeleniumTestHelper.setupHelper(driver);
        objTestPage = new SeleniumSimpleForm(driver);
    }

    @AfterEach
    void tearDown() {
        driver.close();
        driver.quit();
    }

}
