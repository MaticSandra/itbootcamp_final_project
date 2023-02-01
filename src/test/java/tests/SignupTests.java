package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
        homePage.clickSignup();


    }

    @Test
    public void visitsTheSignupPage() {
        String expRoute = "/signup";
        homePage.waitForRoute(expRoute);
//        System.out.println(driver.getCurrentUrl());
        Assert.assertTrue(driver.getCurrentUrl().endsWith(expRoute));

    }

    @Test
    public void checkInputTypes() {
        String expEmailType = "email";
        String expPasswordType = "password";
        signupPage.waitForRoute("/signup");
//        driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.className("container")));
        Assert.assertTrue(signupPage.getInputSignupEmail().getAttribute("type").contains(expEmailType));
        Assert.assertTrue(signupPage.getInputPassword().getAttribute("type").contains(expPasswordType));
        Assert.assertTrue(signupPage.getInputPassword().getAttribute("type").contains(expPasswordType));
//        signupPage.signUpForm();

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
        System.out.println(driver.getCurrentUrl());
        Assert.assertTrue(driver.getCurrentUrl().endsWith(expRoute));
    }
    @Test
    public void signup(){

        String name = "Sandra Matic";
        String email = faker.internet().emailAddress();
        String password = "1234567";
        String confirm = "1234567";
        String expMessageAlreadyExist = "IMPORTANT: Verify your account";

        signupPage.signUpForm(name, email, password, confirm);
        signupPage.waitForSignupImportant();
        Assert.assertTrue(signupPage.getImportantMessage().contains(expMessageAlreadyExist));
    }

}
