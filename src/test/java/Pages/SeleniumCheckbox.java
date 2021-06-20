package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SeleniumCheckbox {

    WebDriver driver;

    By singleCheckbox = By.id("isAgeSelected");

    By firstCheckbox = By.xpath("//label[text()='Option 1']/input");

    By secondCheckbox = By.xpath("//label[text()='Option 2']/input");

    By thirdCheckbox = By.xpath("//label[text()='Option 3']/input");

    By fourthCheckbox = By.xpath("//label[text()='Option 4']/input");

    By checkButton = By.id("check1");

    public SeleniumCheckbox(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnSingleCheckbox() {
        driver.findElement(singleCheckbox).click();
    }

    public void clickOnFirstCheckbox() {
        driver.findElement(firstCheckbox).click();
    }

    public void clickOnSecondCheckbox() {
        driver.findElement(secondCheckbox).click();
    }

    public void clickOnThirdCheckbox() {
        driver.findElement(thirdCheckbox).click();
    }

    public void clickOnFourthCheckbox() {
        driver.findElement(fourthCheckbox).click();
    }

    public String getCheckBtnValue() {
        return driver.findElement(checkButton).getAttribute("value");
    }

    public boolean singleCheckboxIsSelected() {
        return driver.findElement(singleCheckbox).isSelected();
    }
}
