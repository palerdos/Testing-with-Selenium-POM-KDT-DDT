package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SeleniumTestPage {

    WebDriver driver;

    By inputFormMenu = By.linkText("Input Forms");

    By simpleFormMenu = By.linkText("Simple Form Demo");

    By checkboxMenu = By.linkText("Checkbox Demo");

    By selectDropdownListMenu = By.linkText("Select Dropdown List");

    WebDriverWait wait;

    public SeleniumTestPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickInputFormMenu() {
        driver.findElement(inputFormMenu).click();
    }

    public void clickSimpleFormMenu() {
        driver.findElement(simpleFormMenu).click();
    }

    public void clickCheckboxMenu() {driver.findElement(checkboxMenu).click();}

    public void clickSelectDropdownListMenu() {driver.findElement(selectDropdownListMenu).click();}

    public String getURL() {
        return driver.getCurrentUrl();
    }
}
