package pages;

import commons.utils.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage extends PageObject {

    @FindBy(how = How.ID, using = "x-auto-15-input")
    private WebElement usernameField;

    @FindBy(how = How.ID, using = "x-auto-16-input")
    private WebElement passwordField;

    @FindBy(how = How.XPATH, using = "//*[@id=\"x-auto-12\"]/tbody/tr[2]/td[2]/em/button")
    private WebElement loginButton;

    @FindBy(how = How.XPATH, using = "//*[@id=\"x-auto-11\"]/tbody/tr[2]/td[2]/em/button")
    private WebElement resetButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void setUsername(String username) {
        this.usernameField.clear();
        this.usernameField.sendKeys(username);
    }

    public void setPassword(String password) {
        this.passwordField.clear();
        this.passwordField.sendKeys(password);
    }

    public void clickOnResetButton() {
        this.usernameField.clear();
        this.passwordField.clear();
    }

    public WelcomePage clickOnLoginButton() {
        loginButton.click();
        return new WelcomePage(driver);
    }

}
