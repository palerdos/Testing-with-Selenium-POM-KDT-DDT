package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SeleniumCheckbox {

    WebDriver driver;

    By singleCheckbox = By.id("isAgeSelected");

    public SeleniumCheckbox(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnSingleCheckbox() {
        driver.findElement(singleCheckbox).click();
    }

    public boolean singleCheckboxIsSelected() {
        return driver.findElement(singleCheckbox).isSelected();
    }
}
