package Tests;

import Page.PageHomeUserInterface;
import Page.PageUserInterfaceUI;
import aquality.selenium.browser.AqualityServices;
import aquality.selenium.browser.Browser;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;
import utils.ConfigConst;

public class TestHelpWindow {
    private final ConfigConst configConst = new ConfigConst();
    private final PageHomeUserInterface pageHomeUserInterface = new PageHomeUserInterface();
    private final PageUserInterfaceUI pageUserInterfaceUI = new PageUserInterfaceUI();
    private final Browser browser = AqualityServices.getBrowser();

    @BeforeClass
    private void setUp() {
        browser.maximize();
        browser.goTo(configConst.url);
        pageHomeUserInterface.state().waitForDisplayed();
    }

    @BeforeMethod
    private void preConditionHelpForm() {
        pageHomeUserInterface.clickLinkToNextPage();
    }

    @Test
    public void hideHelpForm() {
        pageUserInterfaceUI.selectHideHelpWindow();
        Assert.assertTrue(pageUserInterfaceUI.confirmClosingHelpWindow(), "Help form did not close");
    }

    @AfterClass
    private void out() {
        browser.quit();
    }
}
