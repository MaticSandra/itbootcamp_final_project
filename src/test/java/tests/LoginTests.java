package tests;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LandingPage;
import pages.LoginPage;

public class LoginTests extends BaseTest {

    LandingPage landingPage;
    HomePage homePage;
    LoginPage loginPage;

    @BeforeClass
    @Override
    public void beforeClass() {
        super.beforeClass();
        landingPage = new LandingPage(driver, driverWait);
        homePage = new HomePage(driver, driverWait);
        loginPage = new LoginPage(driver, driverWait);
    }

    @BeforeMethod
    @Override
    public void beforeMethod() {
        super.beforeMethod();
        landingPage.clickLoginTab();
    }

    @Test
    public void VisitsTheLoginPage() {
        driver.getCurrentUrl();
        Assert.assertTrue(driver.getCurrentUrl().endsWith("/login"));
    }

    @Test
    public void checksInputTypes() {
        String expEmailType = "email";
        String expPaswordType = "password";
        Assert.assertTrue(loginPage.getInputFieldEmail().getAttribute("type").contains(expEmailType));
        Assert.assertTrue(loginPage.getInputFieldPassword().getAttribute("type").contains(expPaswordType));
    }

    @Test
    public void userDontExist() {
        String expErrorMessage = "User does not exists";
        String expRoute = "/login";
        String email = faker.internet().emailAddress();
        String password = faker.internet().password();
        loginPage.loginForm(email, password);
        Assert.assertTrue(loginPage.getErrorMessage().contains(expErrorMessage));
        Assert.assertTrue(driver.getCurrentUrl().contains(expRoute));
    }

    @Test
    public void displaysErrorsWrongPassword() {
        loginPage.loginForm("admin@admin.com", "aaddmm1");
        String expWrongPassMessage = "Wrong password";
        String expRoute = "/login";
        Assert.assertTrue(loginPage.getErrorWrongPassword().contains(expWrongPassMessage));
        Assert.assertTrue(driver.getCurrentUrl().contains(expRoute));

    }

    @Test
    public void login() {
        loginPage.loginForm("admin@admin.com", "12345");
        String expRoute = "/home";
        loginPage.waitForRoute(expRoute);
        Assert.assertTrue(driver.getCurrentUrl().endsWith(expRoute));
    }

    @Test
    public void logout() {
        loginPage.loginForm("admin@admin.com", "12345");
        homePage.waitForRoute("/home");
        Assert.assertTrue(homePage.isDisplayed());
        homePage.clickLogout();
        String expRoute = "/login";
        loginPage.waitForRoute(expRoute);
        Assert.assertTrue(driver.getCurrentUrl().endsWith(expRoute));
        driver.get("https://vue-demo.daniel-avellaneda.com/home");
        driver.navigate().refresh();
        Assert.assertTrue(driver.getCurrentUrl().endsWith(expRoute));
    }

    @AfterMethod
    public void afterMethod() {
        if (loginPage.getIfImLoggedIn()) {
            homePage.clickLogout();
        }
    }
}

