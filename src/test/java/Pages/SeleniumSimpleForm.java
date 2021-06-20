package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SeleniumSimpleForm {

    WebDriver driver;

    By singleInputField = By.id("user-message");

    By showMessageBtn = By.xpath("//button[contains(text(),'Show Message')]");

    By singleInputDisplay = By.id("display");

    By inputFieldA = By.id("sum1");

    By inputFieldB = By.id("sum2");

    By getTotalBtn = By.xpath("//button[contains(text(),'Get Total')]");

    By twoInputDisplay = By.id("displayvalue");

    public SeleniumSimpleForm(WebDriver driver) {
        this.driver = driver;
    }

    public void enterInputMessage(String input) {
        driver.findElement(singleInputField).sendKeys(input);
    }

    public void clickOnShowMessage() {
        driver.findElement(showMessageBtn).click();
    }

    public String getDisplayedMessage() {
        return driver.findElement(singleInputDisplay).getText();
    }

    public void enterInputFieldAMessage(String input) {
        driver.findElement(inputFieldA).sendKeys(input);
    }

    public void enterInputFieldBMessage(String input) {
        driver.findElement(inputFieldB).sendKeys(input);
    }

    public void clickOnGetTotalBtn() {
        driver.findElement(getTotalBtn).click();
    }

    public String getTwoInputFieldResult() {
        return driver.findElement(twoInputDisplay).getText();
    }
}
