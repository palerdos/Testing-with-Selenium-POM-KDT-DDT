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

    @ParameterizedTest
    @CsvFileSource(resources = "/twoFieldData.csv", numLinesToSkip = 1)
    void twoFieldsAndOutput(String aInput, String bInput, String expected) throws Exception {
        uiOperation.click(allObjects, "inputMenuOption", "link");
        uiOperation.click(allObjects, "simpleFormMenuOption", "link");
        uiOperation.sendKeys(allObjects, "aInputField", "id", aInput);
        uiOperation.sendKeys(allObjects, "bInputField", "id", bInput);
        uiOperation.click(allObjects, "getTotalBtn", "xpath");
        assertEquals(expected, uiOperation.getText(allObjects, "getTotalValue", "id"));
    }

    @Test
    void singleCheckBox() throws Exception {
        uiOperation.click(allObjects, "inputMenuOption", "link");
        uiOperation.click(allObjects, "checkboxMenuOption", "link");
        uiOperation.click(allObjects, "singleCheckbox", "id");
        assertTrue(uiOperation.isSelected(allObjects, "singleCheckbox", "id"));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/selectListData.csv", numLinesToSkip = 1)
    void selectList(String input) throws Exception {
        uiOperation.click(allObjects, "inputMenuOption", "link");
        uiOperation.click(allObjects, "selectListMenuOption", "link");
        uiOperation.click(allObjects, "selectList", "id");
        assertTrue(selectListHelper(input));
    }

    boolean selectListHelper(String day) throws Exception {
        boolean result = false;
        switch (day) {
            case "Sunday":
                uiOperation.click(allObjects, "sunday", "xpath");
                result = uiOperation.isSelected(allObjects, "sunday", "xpath");
                break;
            case "Monday":
                uiOperation.click(allObjects, "monday", "xpath");
                result = uiOperation.isSelected(allObjects, "monday", "xpath");
                break;
            case "Tuesday":
                uiOperation.click(allObjects, "tuesday", "xpath");
                result = uiOperation.isSelected(allObjects, "tuesday", "xpath");
                break;
            case "Wednesday":
                uiOperation.click(allObjects, "wednesday", "xpath");
                result = uiOperation.isSelected(allObjects, "wednesday", "xpath");
                break;
            case "Thursday":
                uiOperation.click(allObjects, "thursday", "xpath");
                result = uiOperation.isSelected(allObjects, "thursday", "xpath");
                break;
            case "Friday":
                uiOperation.click(allObjects, "friday", "xpath");
                result = uiOperation.isSelected(allObjects, "friday", "xpath");
                break;
            case "Saturday":
                uiOperation.click(allObjects, "saturday", "xpath");
                result = uiOperation.isSelected(allObjects, "saturday", "xpath");
                break;
        }
        return result;
    }

}
