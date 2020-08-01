package pages;

import commons.utils.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WelcomePage extends PageObject {

    @FindBy(xpath = "//*[@id=\"x-auto-33\"]")
    private WebElement welcomeHeader;

    public WelcomePage(WebDriver driver) {
        super(driver);
    }

    public boolean isPageOpened() {
        return welcomeHeader.isDisplayed();
    }
}
