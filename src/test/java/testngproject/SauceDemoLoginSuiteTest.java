package testngproject;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import testngproject.browser.Browser;
import testngproject.selectors.Selectors;
import testngproject.urls.Urls;

public class SauceDemoLoginSuiteTest extends Browser {
    String actualErrorMessage, expectedErrorMessage;

    @BeforeMethod
    public void setUp() {
        setUpBrowser("chrome");
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
