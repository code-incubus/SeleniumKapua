import commons.utils.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import pages.LoginPage;
import pages.WelcomePage;
import qa.markers.LoginTests;

@Category(LoginTests.class)
public class LoginPageTest extends DriverManager {

    private static final Logger logger = LogManager.getLogger(LoginPageTest.class);

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
