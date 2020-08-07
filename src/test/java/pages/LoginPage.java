package pages;

import commons.utils.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Initialized page object for {@link LoginPage} class
 * @author code-incubus
 */
public class LoginPage extends PageObject {

    /**
     * The {@link #usernameField} of this {@link LoginPage}.
     */
    @FindBy(how = How.ID, using = "x-auto-15-input")
    private WebElement usernameField;

    /**
     * The {@link #passwordField} of this {@link LoginPage}.
     */
    @FindBy(how = How.ID, using = "x-auto-16-input")
    private WebElement passwordField;

    /**
     * The {@link #loginButton} of this {@link LoginPage}.
     */
    @FindBy(how = How.XPATH, using = "//*[@id=\"x-auto-12\"]/tbody/tr[2]/td[2]/em/button")
    private WebElement loginButton;

    /**
     * The {@link #resetButton} of this {@link LoginPage}.
     */
    @FindBy(how = How.XPATH, using = "//*[@id=\"x-auto-11\"]/tbody/tr[2]/td[2]/em/button")
    private WebElement resetButton;

    /**
     * LoginPage constructor
     * @author code-incubus
     */
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Sets the username for this {@link LoginPage}.
     * @param username set for this {@link LoginPage}.
     * @author code-incubus
     */
    public void setUsername(String username) {
        this.usernameField.sendKeys(username);
    }

    /**
     * Sets the password for this {@link LoginPage}.
     * @param password set for this {@link LoginPage}.
     * @author code-incubus
     */
    public void setPassword(String password) {
        this.passwordField.sendKeys(password);
    }

    /**
     * Click on reset button for this {@link LoginPage}.
     * @author code-incubus
     */
    public void clickOnResetButton() {
        resetButton.click();
    }

    /**
     * Click on login button for this {@link LoginPage}
     * @return initialized instanceof {@link WelcomePage}
     */
    public WelcomePage clickOnLoginButton() {
        loginButton.click();
        return new WelcomePage(driver);
    }

    /**
     * Says whether or not the {@link #isClickable()} enabled.
     * <p>
     * Checks for enabled/disabled button
     * @return {@code true} if {@link #isClickable()} and {@code false} otherwise.
     */
    public boolean isClickable () {
        return resetButton.isEnabled();
    }
}
