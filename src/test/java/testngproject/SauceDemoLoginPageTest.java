package testngproject;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import testngproject.browser.Browser;
import testngproject.selectors.Selectors;
import testngproject.urls.Urls;
import testngproject.browser.BrowserNames;

public class SauceDemoLoginPageTest extends Browser {
    String actualErrorMessage;

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
        findElementById(Selectors.LOGIN_BUTTON).click();
        actualErrorMessage = findElementByCssSelector(Selectors.ERROR_MESSAGE).getText();
        Assert.assertEquals(actualErrorMessage,
                Selectors.ERROR_MESSAGE_WHEN_CLICKED_ON_THE_LOGIN_BUTTON_WITH_EMPTY_FORM);
    }

    @Test
    public void clickOnTheLoginButtonWithOnlyUsernamePopulated() {
        findElementByCssSelector(Selectors.USERNAME_FIELD).sendKeys(Selectors.DUMMY_USERNAME);
        findElementById(Selectors.LOGIN_BUTTON).click();
        actualErrorMessage = findElementByCssSelector(Selectors.ERROR_MESSAGE).getText();
        Assert.assertEquals(actualErrorMessage,
                Selectors.ERROR_MESSAGE_WHEN_CLICKED_ON_THE_LOGIN_BUTTON_WITH_EMPTY_PASSWORD_FIELD);
    }

    @Test
    public void clickOnTheLoginButtonWithOnlyPasswordPopulated() {
        findElementByCssSelector(Selectors.PASSWORD_FIELD).sendKeys(Selectors.DUMMY_PASSWORD);
        findElementById(Selectors.LOGIN_BUTTON).click();
        actualErrorMessage = findElementByCssSelector(Selectors.ERROR_MESSAGE).getText();
        Assert.assertEquals(actualErrorMessage,
                Selectors.ERROR_MESSAGE_WHEN_CLICKED_ON_THE_LOGIN_BUTTON_WITH_EMPTY_USERNAME_FIELD);
    }

    @Test
    public void clickOnTheLoginButtonWithWrongUsernameAndPassword() {
        findElementByCssSelector(Selectors.USERNAME_FIELD).sendKeys(Selectors.DUMMY_USERNAME);
        findElementByCssSelector(Selectors.PASSWORD_FIELD).sendKeys(Selectors.DUMMY_PASSWORD);
        findElementById(Selectors.LOGIN_BUTTON).click();
        actualErrorMessage = findElementByCssSelector(Selectors.ERROR_MESSAGE).getText();
        Assert.assertEquals(actualErrorMessage, Selectors.ERROR_MESSAGE_FOR_WRONG_CREDENTIALS);
    }

    @Test
    public void clickOnTheErrorButton() {
        findElementByCssSelector(Selectors.USERNAME_FIELD).sendKeys(Selectors.DUMMY_USERNAME);
        findElementById(Selectors.LOGIN_BUTTON).click();
        if (findElementByCssSelector(Selectors.ERROR_BUTTON).isDisplayed()) {
            findElementByCssSelector(Selectors.ERROR_BUTTON).click();
            // Boolean isPresent = isPresent(selector)
            Assert.assertTrue(elementNotPresent(Selectors.ERROR_BUTTON));
        } else {
            throw new Error("Unexpected behavior: Error button is displayed");
        }
    }

    @AfterMethod
    public void tearDown() {
        tearDownBrowser();
    }
}
