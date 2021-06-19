package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SeleniumSimpleForm {

    WebDriver driver;

    By singleInputField = By.id("user-message");

    By showMessageBtn = By.xpath("//button[contains(text(),'Show Message')]");

    By singleInputDisplay = By.id("display");

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
}
