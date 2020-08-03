import commons.utils.DriverManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.WelcomePage;

public class DemoTest extends DriverManager {

    @Test
    public void loginWithCorrectCredentialsTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUsername("kapua-sys");
        loginPage.setPassword("kapua-password");

        WelcomePage welcomePage = loginPage.clickOnLoginButton();
        Assert.assertTrue(welcomePage.isPageOpened());
    }
    @Test
    public void resetPasswordAndUsernameFieldTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUsername("username");
        loginPage.setPassword("password");
        loginPage.clickOnResetButton();
        Assert.assertTrue(loginPage.isClickable());
    }
}
