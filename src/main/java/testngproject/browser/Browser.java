package testngproject.browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Browser {

    public WebDriver driver;

    public void setUpBrowser(String browser) {
        WebDriverManager.chromedriver().setup();
        switch (browser) {
        case "chrome":
            driver = new ChromeDriver();
            break;
        case "firefox":
            driver = new FirefoxDriver();
            break;
        default:
            throw new Error(browser + " is not supported");
        }
    }

    public void tearDownBrowser() {
        driver.close();
        driver.quit();
    }
}
