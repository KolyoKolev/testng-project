package testngproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import testngproject.selectors.Selectors;
import testngproject.urls.Urls;

public class SauceDemoLoginSuiteTest {
    WebDriver driver;
    String actualErrorMessage, expectedErrorMessage;

    @BeforeMethod
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

    @Test
    public void clickOnTheLoginButtonWithEmptyForm() {
        expectedErrorMessage = "Epic sadface: Username is required";
        driver.findElement(By.id(Selectors.LOGIN_BUTTON)).click();
        actualErrorMessage = driver.findElement(By.cssSelector(Selectors.ERROR_MESSAGE)).getText();
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
        driver.quit();
    }
}
