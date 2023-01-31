package tests;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginTests extends BaseTest{

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
        homePage.clickLogin();
    }

    @Test
    public void VisitsTheLoginPage(){
        driver.getCurrentUrl();
        Assert.assertTrue(driver.getCurrentUrl().endsWith("/login"));
    }
    @Test
    public void checksInputTypes(){
       String expEmailType = "email";
       String expPaswordType = "password";
       Assert.assertTrue(loginPage.getInputFieldEmail().getAttribute("type").contains(expEmailType));
       Assert.assertTrue(loginPage.getInputFieldPassword().getAttribute("type").contains(expPaswordType));
    }
    @Test
    public void userDontExist(){
        Faker faker = new Faker();
        String expErrorMessage = "User does not exists";
        String expRoute = "/login";
        loginPage.loginForm(faker.internet().emailAddress(), faker.internet().password());
        Assert.assertTrue(loginPage.getErrorMesage().contains(expErrorMessage));
        Assert.assertTrue(driver.getCurrentUrl().contains(expRoute));

    }
    @Test
    public void displaysErrorsWrongPassword(){
    loginPage.loginForm("admin@admin.com", "aaddmm1");
    String expWrongPassMessage = "Wrong password";
    String expRoute = "/login";
    Assert.assertTrue(loginPage.getErrorWrongPassword().contains(expWrongPassMessage));
        Assert.assertTrue(driver.getCurrentUrl().contains(expRoute));

    }

    @Test
    public void login(){
        loginPage.loginForm("admin@admin.com", "12345");
        String expRoute = "/home";
        loginPage.waitForRoute(expRoute);
        Assert.assertTrue(driver.getCurrentUrl().endsWith(expRoute));
    }
    @Test
    public void logout(){
        loginPage.loginForm("admin@admin.com", "12345");
        Assert.assertTrue(homePage.isDisplayed());
        homePage.clickLogout();
        String expRoute = "/login";
        homePage.waitForRoute(expRoute);
        Assert.assertTrue(driver.getCurrentUrl().endsWith(expRoute));
        driver.get("https://vue-demo.daniel-avellaneda.com/home");
        driver.navigate().refresh();
        Assert.assertTrue(driver.getCurrentUrl().endsWith(expRoute));









    }





//    @AfterClass
//    @Override
//    public void afterClass() {
//        super.afterClass();
//    }
}
