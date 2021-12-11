package Tests;

import Page.PageHomeUserInterface;
import Page.PageUserInterfaceUI;
import aquality.selenium.browser.AqualityServices;
import aquality.selenium.browser.Browser;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.ConfigConst;

public class TestTimer {
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
    private void preConditionTimerBar() {
        pageHomeUserInterface.clickLinkToNextPage();
    }

    @Test
    public void checkTimerField() {
        Assert.assertEquals(pageUserInterfaceUI.getTimeInField(), configConst.startTiming
                , "timer did not start from 0");

    }

    @AfterClass
    private void out() {
        browser.quit();
    }
}
