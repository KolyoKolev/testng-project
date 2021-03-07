package testngproject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import testngproject.urls.Urls;

public class SauceDemoLoginSuiteTest {
    WebDriver driver;

    @BeforeTest
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get(Urls.SAUCER_DEMO_LOGIN_PAGE);
    }

    @Test
    public void validateTheCurrentUrl() {
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, Urls.SAUCER_DEMO_LOGIN_PAGE);
    }

    @AfterTest
    public void tearDown() {
        driver.close();
        driver.quit();
    }
}
