package tests;

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
        loginPage.clickOnLoginButton();

        WelcomePage welcomePage = loginPage.clickOnLoginButton();
        Assert.assertTrue(welcomePage.isPageOpened());
    }
    @Test
    public void test2() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUsername("username");
        loginPage.setPassword("password");
        loginPage.clickOnResetButton();
    }
}
