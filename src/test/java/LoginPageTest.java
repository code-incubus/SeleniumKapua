import commons.utils.DriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
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
    @Description("This test case validate login with valid credentials.")
    @Severity(SeverityLevel.NORMAL)
    @Feature("LoginFeature")
    public void loginWithCorrectCredentialsTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUsername("kapua-sys");
        loginPage.setPassword("kapua-password");

        WelcomePage welcomePage = loginPage.clickOnLoginButton();
        Assert.assertTrue(welcomePage.isPageOpened());
    }

    @Test
    @Description("This test case reset username and password from input login field.")
    @Severity(SeverityLevel.NORMAL)
    @Feature("LoginFeature")
    public void resetPasswordAndUsernameFieldTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUsername("username");
        loginPage.setPassword("password");
        loginPage.clickOnResetButton();
        Assert.assertTrue(loginPage.isClickable());
    }
}
