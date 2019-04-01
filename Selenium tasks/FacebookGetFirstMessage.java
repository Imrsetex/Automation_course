package PDFfiller_Automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FacebookGetFirstMessage {

    private String pass = "serega1988";
    private String email = "imrsetex@gmail.com";
    private By emailInput = By.xpath("//input[@name='email']");
    private By passInput = By.xpath("//input[@name='pass']");
    private By loginBtn = By.xpath("//button[@id='loginbutton']");
    private By messageBtn = By.xpath("//div[@*='uiToggle _4962 _1z4y _330i _4kgv']");
    private By messages = By.xpath("//*[@class='_1ijj']//span//span");

    @Test
    public void facebookTest() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/sergey/webDrivers/chromedriver");
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("profile.default_content_setting_values.notifications", 2);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);
        WebDriver driver = new ChromeDriver(options);

        driver.get("https://facebook.com/login");

        driver.findElement(emailInput).sendKeys(email);
        driver.findElement(passInput).sendKeys(pass);
        driver.findElement(loginBtn).click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(messageBtn).isDisplayed();
        driver.findElement(messageBtn).click();
        Thread.sleep(2000);

        WebElement messagesList = driver.findElement(messages);
        List<WebElement> rows = messagesList.findElements(messages);
        System.out.println(rows.get(0).getText());

        driver.quit();
    }
}
