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

import java.io.File;

public class TestRegistrationForm {
    private final ConfigConst configConst = new ConfigConst();
    private final PageHomeUserInterface pageHomeUserInterface = new PageHomeUserInterface();
    private final PageUserInterfaceUI pageUserInterfaceUI = new PageUserInterfaceUI();
    private final Browser browser = AqualityServices.getBrowser();
    private static final int NUMBERRANDOMDOMAIN = 1;
    private static final int RENGESELECTIONNUMBERSDOMAIN = 9;
    private static final int SKIPCHECKBOXDOMAIN = 0;
    private static final int NUMBERRANDOMNUMBERS = 3;
    private static final int RENGESELECTIONNUMBERS = 19;
    private static final int SKIPCHECKBOX = 17;
    private static final String PATHTOIMAGE = new File("./src/test/resources/avatar.png").getAbsolutePath();


    @BeforeClass
    private void setUp() {
        browser.maximize();
        browser.goTo(configConst.url);
        pageHomeUserInterface.state().waitForDisplayed();
    }

    @BeforeMethod
    private void preConditionRegistrationForm() {
        pageHomeUserInterface.clickLinkToNextPage();
    }

    @Test
    public void registrationForm() {
        Assert.assertEquals(pageUserInterfaceUI.indicatorNumberMenu(), configConst.numberMenuOne
                , "did not switch to the menu one");
        pageUserInterfaceUI.inputDomain();
        pageUserInterfaceUI.inputRandomPass();
        pageUserInterfaceUI.inputRandomEmail();
        pageUserInterfaceUI.selectTerms();
        pageUserInterfaceUI.selectRandomDomainBox(NUMBERRANDOMDOMAIN, RENGESELECTIONNUMBERSDOMAIN, SKIPCHECKBOXDOMAIN);
        pageUserInterfaceUI.selectNextMenuOne();
        Assert.assertEquals(pageUserInterfaceUI.indicatorNumberMenu(), configConst.numberMenuTwo
                , "did not switch to the menu two");
        pageUserInterfaceUI.uploadImage(PATHTOIMAGE);
        pageUserInterfaceUI.randomSelectCheckBox(NUMBERRANDOMNUMBERS, RENGESELECTIONNUMBERS, SKIPCHECKBOX);
        pageUserInterfaceUI.selectNextMenuTwo();
        Assert.assertEquals(pageUserInterfaceUI.indicatorNumberMenu(), configConst.numberMenuThree
                , "did not switch to the menu three");
    }

    @AfterClass
    private void out() {
        browser.quit();
    }
}
