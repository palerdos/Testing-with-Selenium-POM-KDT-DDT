package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SeleniumRadioButton {

    WebDriver driver;

    By male = By.xpath("//input[@name='gender' and @value='Male']");

    By female = By.xpath("//input[@name='gender' and @value='Female']");

    By zeroToFive = By.xpath("//input[@name='ageGroup' and @value='0 - 5']");

    By fiveToFifteen = By.xpath("//input[@name='ageGroup' and @value='5 - 15']");

    By fifteenToFifty = By.xpath("//input[@name='ageGroup' and @value='15 - 50']");

    By displayMessage = By.cssSelector(".groupradiobutton");

    By getValuesBtn = By.xpath("//button[contains(text(),'Get values')]");

    public SeleniumRadioButton(WebDriver driver) {
        this.driver = driver;
    }

    void clickMale() {driver.findElement(male).click();}

    void clickFemale() {driver.findElement(female).click();}

    void clickZeroToFive() {driver.findElement(zeroToFive).click();}

    void clickFiveToFifteen() {driver.findElement(fiveToFifteen).click();}

    void clickFifteenToFifty() {driver.findElement(fifteenToFifty).click();}

    public void clickGetValuesBtn() {driver.findElement(getValuesBtn).click();}

    public String getDisplayedMessage() {return driver.findElement(displayMessage).getText();}

    public void radioButtonGenderHelper(String gender) {
        if (gender.equals("male")) {
            clickMale();
        } else {
            clickFemale();
        }
    }

    public void radioButtonAgeHelper(String age) {
        switch (age) {
            case "0to5":
                clickZeroToFive();
                break;
            case "5to15":
                clickFiveToFifteen();
                break;
            case "15to50":
                clickFifteenToFifty();
                break;
        }
    }
}
