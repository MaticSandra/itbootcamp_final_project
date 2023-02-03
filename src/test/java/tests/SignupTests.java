package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LandingPage;
import pages.LoginPage;
import pages.SignupPage;

public class SignupTests extends BaseTest {

    LandingPage landingPage;

    HomePage homePage;
    SignupPage signupPage;

    LoginPage loginPage;

    @BeforeClass
    @Override
    public void beforeClass() {
        super.beforeClass();
        landingPage = new LandingPage(driver, driverWait);
        homePage = new HomePage(driver, driverWait);
        signupPage = new SignupPage(driver, driverWait);
    }

    @BeforeMethod
    @Override
    public void beforeMethod() {
        super.beforeMethod();
        landingPage.clickSignupTab();
    }


    @Test
    public void visitsTheSignupPage() {
        String expRoute = "/signup";
        homePage.waitForRoute(expRoute);
        Assert.assertTrue(driver.getCurrentUrl().endsWith(expRoute));
    }

    @Test
    public void checkInputTypes() {
        String expEmailType = "email";
        String expPasswordType = "password";
        signupPage.waitForRoute("/signup");
        Assert.assertTrue(signupPage.getInputSignupEmail().getAttribute("type").contains(expEmailType));
        Assert.assertTrue(signupPage.getInputPassword().getAttribute("type").contains(expPasswordType));
        Assert.assertTrue(signupPage.getInputPassword().getAttribute("type").contains(expPasswordType));
    }

    @Test
    public void displaysErrorsWhenUserAlreadyExists() {
        String name = "Test Test";
        String email = "admin@admin.com";
        String password = "123654";
        String confirm = "123654";
        String expMessage = "E-mail already exists";
        String expRoute = "/signup";
        signupPage.signUpForm(name, email, password, confirm);

        Assert.assertTrue(signupPage.getMessageAlreadyExist().contains(expMessage));
        signupPage.waitForRoute("/signup");
        Assert.assertTrue(driver.getCurrentUrl().endsWith(expRoute));
    }

    @Test
    public void signup() {
        String name = "Sandra Matic";
        String email = faker.internet().emailAddress();
        String password = "1234567";
        String confirm = password;
        String expMessageAlreadyExist = "IMPORTANT: Verify your account";

        signupPage.signUpForm(name, email, password, confirm);
        homePage.waitForSignupImportant();
        Assert.assertTrue(homePage.getImportantMessage().contains(expMessageAlreadyExist));
        homePage.getCloseDialogBtn().click();
        homePage.clickLogoutButton();
    }

}
