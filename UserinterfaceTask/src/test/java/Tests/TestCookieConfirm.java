package Tests;

import Page.PageHomeUserInterface;
import Page.PageUserInterfaceUI;
import aquality.selenium.browser.AqualityServices;
import aquality.selenium.browser.Browser;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.ConfigConst;

public class TestCookieConfirm {
    private final ConfigConst configConst = new ConfigConst();
    private final PageHomeUserInterface pageHomeUserInterface = new PageHomeUserInterface();
    private final PageUserInterfaceUI pageUserInterfaceUI = new PageUserInterfaceUI();
    private final Browser browser = AqualityServices.getBrowser();

    @BeforeClass
    private void setUp() {
        browser.maximize();
        browser.goTo(configConst.url);
    }

    @BeforeMethod
    private void preConditionCookieConfirm() {
        pageHomeUserInterface.clickLinkToNextPage();
    }

    @Test
    public void cookieConfirm() {
        pageUserInterfaceUI.selectCookie();
        Assert.assertTrue(pageUserInterfaceUI.confirmCookieIsHidden(),"Cookie is hidden");
    }

    @AfterClass
    private void out() {
        browser.quit();
    }
}
