package tests;

import operation.ReadObject;
import operation.UIOperation;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.Properties;

public class ExecuteTest {

    WebDriver driver = new ChromeDriver();
    ReadObject object = new ReadObject();
    Properties allObjects = object.getObjectRepository();
    UIOperation uiOperation = new UIOperation(driver);

    public ExecuteTest() throws IOException {
    }

    @BeforeEach
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        uiOperation.maximize();
        uiOperation.get(allObjects, "startURL");
        uiOperation.waitUntilClickable(allObjects, "adCloseBtn", "id");
        uiOperation.click(allObjects, "adCloseBtn", "id");
    }

    @AfterEach
    void tearDown() {
        uiOperation.close();
        uiOperation.quit();
    }

    @Test
    void navigation() throws Exception {
        uiOperation.click(allObjects, "inputMenuOption", "link");
        uiOperation.click(allObjects, "simpleFormMenuOption", "link");
        assertEquals("https://www.seleniumeasy.com/test/basic-first-form-demo.html", uiOperation.getURL());
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/singleFieldData.csv", numLinesToSkip = 1)
    void singleFieldAndButton(String input, String expected) throws Exception {
        uiOperation.click(allObjects, "inputMenuOption", "link");
        uiOperation.click(allObjects, "simpleFormMenuOption", "link");
        uiOperation.sendKeys(allObjects,"singleInputField", "id", input);
        uiOperation.click(allObjects, "showMessageBtn", "xpath");
        assertEquals(expected, uiOperation.getText(allObjects, "singleInputDisplay", "id"));
    }
}
