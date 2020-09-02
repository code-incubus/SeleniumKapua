package commons.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Page object is used for initialization of page element for particular page
 * @author code-incubus
 */
public class PageObject {
    protected WebDriver driver;

    /**
     * Constructor with PageFactory.
     * @param driver set for this {@link PageObject}.
     * @author code-incubus
     */
    public PageObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
