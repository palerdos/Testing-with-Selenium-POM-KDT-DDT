package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SeleniumSelectList {

    WebDriver driver;

    By selectList = By.id("select-demo");

    By selectedMessage;

    By sunday = By.xpath("//option[contains(text(),'Sunday')]");

    By monday = By.xpath("//option[contains(text(),'Monday')]");

    By tuesday = By.xpath("//option[contains(text(),'Tuesday')]");

    By wednesday = By.xpath("//option[contains(text(),'Wednesday')]");

    By thursday = By.xpath("//option[contains(text(),'Thursday')]");

    By friday = By.xpath("//option[contains(text(),'Friday')]");

    By saturday = By.xpath("//option[contains(text(),'Saturday')]");

    void clickSelectList() {driver.findElement(selectList).click();}

    void clickSunday() {driver.findElement(sunday).click();}

    void clickMonday() {driver.findElement(monday).click();}

    void clickTuesday() {driver.findElement(tuesday).click();}

    void clickWednesday() {driver.findElement(wednesday).click();}

    void clickThursday() {driver.findElement(thursday).click();}

    void clickFriday() {driver.findElement(friday).click();}

    void clickSaturday() {driver.findElement(saturday).click();}

    public SeleniumSelectList(WebDriver driver) {
        this.driver = driver;
    }

    public String getSelectedMessage(String day) {return driver.findElement(selectedMessage).getText();}

    public void selectListHelper(String day) throws Exception {
        switch (day) {
            case "Sunday":
                clickSunday();
                selectedMessage = By.xpath("//p[contains(text(),'Day selected :- "+day+"')]");
                break;
            case "Monday":
                clickMonday();
                selectedMessage = By.xpath("//p[contains(text(),'Day selected :- "+day+"')]");
                break;
            case "Tuesday":
                clickTuesday();
                selectedMessage = By.xpath("//p[contains(text(),'Day selected :- "+day+"')]");
                break;
            case "Wednesday":
                clickWednesday();
                selectedMessage = By.xpath("//p[contains(text(),'Day selected :- "+day+"')]");
                break;
            case "Thursday":
                clickThursday();
                selectedMessage = By.xpath("//p[contains(text(),'Day selected :- "+day+"')]");
                break;
            case "Friday":
                clickFriday();
                selectedMessage = By.xpath("//p[contains(text(),'Day selected :- "+day+"')]");
                break;
            case "Saturday":
                clickSaturday();
                selectedMessage = By.xpath("//p[contains(text(),'Day selected :- "+day+"')]");
                break;
        }
    }

}
