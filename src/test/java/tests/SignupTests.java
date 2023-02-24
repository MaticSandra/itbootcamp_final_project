package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SignupPage;

public class SignupTests extends BaseTest {

    HomePage homePage;
    SignupPage signupPage;

    @BeforeClass
    @Override
    public void beforeClass() {
        super.beforeClass();
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
        signupPage.waitForRoute("/signup");
        Assert.assertTrue(driver.getCurrentUrl().endsWith("/signup"));
    }

    @Test
    public void checkInputTypes() {
        String email = "email";
        String password = "password";
        signupPage.waitForRoute("/signup");
        Assert.assertTrue(signupPage.getInputSignupEmail().getAttribute("type").contains(email));
        Assert.assertTrue(signupPage.getInputPassword().getAttribute("type").contains(password));
        Assert.assertTrue(signupPage.getInputPassword().getAttribute("type").contains(password));
    }

    @Test
    public void userAlreadyExists() {
        String name = "Test Test";
        String email = "admin@admin.com";
        String password = "123654";
        String confirm = "123654";
        signupPage.signUpForm(name, email, password, confirm);

        Assert.assertTrue(signupPage.getMessageAlreadyExist().contains("E-mail already exists"));
        signupPage.waitForRoute("/signup");
        Assert.assertTrue(driver.getCurrentUrl().endsWith("/signup"));
    }

    @Test
    public void signup() {
        String name = "Sandra Matic";
        String email = faker.internet().emailAddress();
        String password = "1234567";
        String confirm = password;
        signupPage.signUpForm(name, email, password, confirm);
        homePage.waitForSignupImportant();
        Assert.assertTrue(homePage.getImportantMessage().contains("IMPORTANT: Verify your account"));
        homePage.getCloseDialogBtn().click();
        homePage.clickLogoutButton();
    }

}
