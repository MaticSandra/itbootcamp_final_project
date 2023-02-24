package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AdminCitiesPage;
import pages.HomePage;
import pages.LoginPage;

public class LoginTests extends BaseTest {

    HomePage homePage;
    LoginPage loginPage;

    @BeforeClass
    @Override
    public void beforeClass() {
        super.beforeClass();
        homePage = new HomePage(driver, driverWait);
        loginPage = new LoginPage(driver, driverWait);
    }

    @BeforeMethod
    @Override
    public void beforeMethod() {
        super.beforeMethod();
        landingPage.clickLoginTab();
    }

    @AfterMethod
    public void afterMethod() {
        homePage.clickLogoutButton();
    }

    @Test
    public void visitsTheLoginPage() {
        driver.getCurrentUrl();
        Assert.assertTrue(driver.getCurrentUrl().endsWith("/login"));
    }

    @Test
    public void checksInputTypes() {
        Assert.assertTrue(loginPage.getInputFieldEmail().getAttribute("type").contains("email"));
        Assert.assertTrue(loginPage.getInputFieldPassword().getAttribute("type").contains("password"));
    }

    @Test
    public void userDontExist() {
        String email = faker.internet().emailAddress();
        String password = faker.internet().password();
        loginPage.loginForm(email, password);
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
        Assert.assertTrue(loginPage.getDontExistMessage().contains("User does not exists"));
    }

    @Test
    public void displaysErrorsWrongPassword() {
        loginPage.loginForm("admin@admin.com", "aaddmm1");
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
        Assert.assertTrue(loginPage.getErrorWrongPassword().contains("Wrong password"));
    }

    @Test
    public void login() {
        loginPage.loginForm("admin@admin.com", "12345");
        loginPage.waitForRoute("/home");
        Assert.assertTrue(driver.getCurrentUrl().endsWith("/home"));
    }

    @Test
    public void logout() {
        loginPage.loginForm("admin@admin.com", "12345");
        homePage.waitForRoute("/home");
        homePage.clickLogoutButton();
        loginPage.waitForRoute("/login");
        Assert.assertTrue(driver.getCurrentUrl().endsWith("/login"));
        getHomeUrl();
        driver.navigate().refresh();
        Assert.assertTrue(driver.getCurrentUrl().endsWith("/login"));
    }
}

