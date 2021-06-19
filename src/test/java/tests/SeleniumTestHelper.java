package tests;

import Pages.SeleniumTestPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SeleniumTestHelper {

    public static void setupHelper(WebDriver driver) {
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        driver.manage().window().maximize();
        driver.get("https://www.seleniumeasy.com/test/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("at-cv-lightbox-close")));
        driver.findElement(By.id("at-cv-lightbox-close")).click();
    }

}
