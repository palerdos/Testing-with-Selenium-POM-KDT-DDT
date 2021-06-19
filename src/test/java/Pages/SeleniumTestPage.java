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

    By adCloseBtn = By.id("at-cv-lightbox-close");

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

    public String getURL() {
        return driver.getCurrentUrl();
    }

    public void clickAdCloseBtn() {
        driver.findElement(adCloseBtn).click();
    }

    public void waitForAdClickable(WebDriver driver) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(adCloseBtn));
    }
}
