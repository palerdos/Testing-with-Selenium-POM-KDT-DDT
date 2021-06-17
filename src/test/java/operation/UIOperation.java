package operation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Properties;

public class UIOperation {
    WebDriver driver;

    public UIOperation(WebDriver driver) {
        this.driver = driver;
    }

    public void click(Properties properties,String objectName, String objectType) throws Exception {
        driver.findElement(this.getObject(properties, objectName, objectType)).click();
    }

    public String getURL() {
        return driver.getCurrentUrl();
    }

    public void waitUntilClickable(Properties properties, String objectName, String objectType) throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(this.getObject(properties, objectName, objectType)));
    }

    private By getObject(Properties properties, String objectName, String objectType) throws Exception {
        if(objectType.equalsIgnoreCase("XPATH")){

            return By.xpath(properties.getProperty(objectName));
        }
        //find by class
        else if(objectType.equalsIgnoreCase("CLASSNAME")){

            return By.className(properties.getProperty(objectName));

        }
        //find by name
        else if(objectType.equalsIgnoreCase("NAME")){

            return By.name(properties.getProperty(objectName));

        }
        //Find by css
        else if(objectType.equalsIgnoreCase("CSS")){

            return By.cssSelector(properties.getProperty(objectName));

        }
        //find by link
        else if(objectType.equalsIgnoreCase("LINK")){

            return By.linkText(properties.getProperty(objectName));

        }
        //find by partial link
        else if(objectType.equalsIgnoreCase("PARTIALLINK")){

            return By.partialLinkText(properties.getProperty(objectName));

        }else
        {
            throw new Exception("Wrong object type");
        }
    }


}
