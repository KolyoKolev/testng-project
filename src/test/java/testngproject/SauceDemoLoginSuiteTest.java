package testngproject;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import testngproject.browser.Browser;
import testngproject.selectors.Selectors;
import testngproject.urls.Urls;
import testngproject.browser.BrowserNames;

public class SauceDemoLoginSuiteTest extends Browser {
    String actualErrorMessage, expectedErrorMessage;

    @BeforeMethod
    public void setUp() {
        setUpBrowser(BrowserNames.CHROME);
        maximizeWindow();
        deleteAllCookies();
        getUrl(Urls.SAUCE_DEMO_LOGIN_PAGE);
    }

    @Test
    public void validateTheCurrentUrl() {
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, Urls.SAUCE_DEMO_LOGIN_PAGE);
    }

    @Test
    public void clickOnTheLoginButtonWithEmptyForm() {
        expectedErrorMessage = "Epic sadface: Username is required";
        findElementById(Selectors.LOGIN_BUTTON).click();
        actualErrorMessage = findElementByCssSelector(Selectors.ERROR_MESSAGE).getText();
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
    }

    @AfterMethod
    public void tearDown() {
        tearDownBrowser();
    }
}
