package Page;

import aquality.selenium.elements.ElementType;
import aquality.selenium.elements.interfaces.*;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;
import utils.ConfigConst;
import utils.GenerateRandomMarkedFields;
import utils.ImageLoadUtil;
import utils.RandomTextUtil;


import java.util.List;

public class PageUserInterfaceUI extends Form {
    private final ConfigConst configConst = new ConfigConst();
    private static final int CLEARINTERESTCHECKBOX = 20;
    private static final int LOWERLETTERS = 4;
    private static final int UPPERLETTERSANDDIGITS = 6;
    private final ImageLoadUtil imageLoadUtil = new ImageLoadUtil();
    private final RandomTextUtil randomTextUtil = new RandomTextUtil();
    private final GenerateRandomMarkedFields generateRandomMarkedFields = new GenerateRandomMarkedFields();
    private final String generatingRandomLowerLetters = randomTextUtil.generatingLowerLetters(LOWERLETTERS);
    private final String generatingUpperLettersAndDigits = randomTextUtil
            .generatingUpperLettersAndDigits(UPPERLETTERSANDDIGITS);


    public PageUserInterfaceUI() {
        super(By.className("logo__icon"), "logo UI");
    }

    private final ITextBox emailInputField = getElementFactory()
            .getTextBox(By.xpath("//input[contains(@placeholder, 'Your email')]"), "email Input Field");

    public void inputRandomEmail() {
        emailInputField.clearAndType(generatingRandomLowerLetters);
    }

    private final ITextBox passwordInputField = getElementFactory()
            .getTextBox(By.xpath("//input[contains(@placeholder, 'Choose Password')]"), "password Input Field");

    public void inputRandomPass() {
        passwordInputField.clearAndType(generatingRandomLowerLetters + generatingUpperLettersAndDigits);
    }

    private final ITextBox domainTextBox = getElementFactory()
            .getTextBox(By.xpath("//input[@placeholder = 'Domain']"), "domain Input Field");

    public void inputDomain() {
        domainTextBox.clearAndType(configConst.DOMAIN);
    }

    private final ICheckBox acceptTermsButton = getElementFactory().getCheckBox(By.className("checkbox__box")
            , "Button i do not accept the Terms & Conditions");

    public void selectTerms() {
        acceptTermsButton.check();
    }

    private final IComboBox domainNameBox = getElementFactory().getComboBox(By.className("dropdown__field")
            , "select domain name");

    public void selectRandomDomainBox(int numberRandomNumbers, int rangeSelectionNumbers, int skipCheckBox) {
        domainNameBox.click();
        List<IElement> selectRandomDomain = getElementFactory().findElements(By.className("dropdown__list-item")
                , ElementType.COMBOBOX);
        List<Integer> randomFieldsToSelect = generateRandomMarkedFields.randomSend(numberRandomNumbers
                , rangeSelectionNumbers
                , skipCheckBox);
        for (int i = 0; i < randomFieldsToSelect.size() - 1; i++) {
            selectRandomDomain.get(randomFieldsToSelect.get(i)).click();
        }
    }

    private final IButton nextMenuOneButton = getElementFactory().getButton(By.className("button--secondary")
            , "button next menu one");

    public void selectNextMenuOne() {
        nextMenuOneButton.click();
    }

    private final IButton uploadImageButton = getElementFactory()
            .getButton(By.className("avatar-and-interests__upload-button")
                    , "upload Image");

    public void uploadImage(String pathToImage) {
        uploadImageButton.click();
        imageLoadUtil.uploadImage(pathToImage);
    }

    public void randomSelectCheckBox(int numberRandomNumbers, int rangeSelectionNumbers, int skipCheckBox) {
        List<IElement> send = getElementFactory().findElements(By.className("checkbox__box")
                , ElementType.CHECKBOX);
        send.get(CLEARINTERESTCHECKBOX).click();
        List<Integer> randomMarkedFields = generateRandomMarkedFields
                .randomSend(numberRandomNumbers, rangeSelectionNumbers, skipCheckBox);
        for (int i = 0; i < randomMarkedFields.size() - 1; i++) {
            send.get(randomMarkedFields.get(i)).click();
        }
    }

    private final IButton nextMenuTwoButton = getElementFactory()
            .getButton(By.xpath("//button[contains(@class, 'button button--stroked button--white button--fluid')]")
                    , "select next menu two");

    public void selectNextMenuTwo() {
        nextMenuTwoButton.click();
    }

    private final IButton confirmCookieButton = getElementFactory()
            .getButton(By.xpath("//button[contains(@class, 'button button--solid button--transparent')]")
                    , "button 'Not really, no'");

    public void selectCookie() {
        confirmCookieButton.click();
    }

    public boolean confirmCookieIsHidden() {
        return confirmCookieButton.state().waitForNotDisplayed();
    }

    private final IButton hideHelpWindowButton = getElementFactory()
            .getButton(By.xpath("//button[contains(@class, 'button button--solid button--blue help-form__send-to-bottom-button')]")
                    , "button hide help form");

    public void selectHideHelpWindow() {
        hideHelpWindowButton.click();
    }

    private final ILabel titleHelpWindow = getElementFactory().getLabel(By.className("help-form__title")
            , "title Help Form 'How can we help?'");

    public boolean confirmClosingHelpWindow() {
        return titleHelpWindow.state().waitForNotDisplayed();
    }

    private final ILabel pageIndicatorLabel = getElementFactory().getLabel(By.className("page-indicator")
            , "label menu 3");

    public String indicatorNumberMenu() {
        return pageIndicatorLabel.getText();
    }

    private final ILabel timerFieldLabel = getElementFactory()
            .getLabel(By.xpath("//div[contains(@class, 'timer timer--white timer--center')]"), "timer bar");

    public String getTimeInField() {
        return timerFieldLabel.getText();
    }

}
