package Page;


import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class PageHomeUserInterface extends Form {
    public PageHomeUserInterface() {
        super(By.className("logo__icon"), "Logo page user interface");
    }

    private final IButton linkToNextPage = getElementFactory().getButton(By.className("start__link")
            , "Follow the link to the next page");

    public void clickLinkToNextPage() {
        linkToNextPage.click();
    }
}
