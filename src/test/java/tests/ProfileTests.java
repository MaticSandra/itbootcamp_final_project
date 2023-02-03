package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

public class ProfileTests extends BaseTest {
//    LandingPage landingPage;

    LoginPage loginPage;
    HomePage homePage;
    SignupPage signupPage;
    ProfilePage profilePage;

    @BeforeClass
    @Override
    public void beforeClass() {
        super.beforeClass();
        homePage = new HomePage(driver, driverWait);
        loginPage = new LoginPage(driver, driverWait);
        signupPage = new SignupPage(driver, driverWait);
        profilePage = new ProfilePage(driver, driverWait);
    }
    @BeforeMethod
    @Override
    public void beforeMethod() {
        super.beforeMethod();
    }

    public void signUpWithData() {
        landingPage.clickSignupTab();
        String name = "Sandra Matic";
        String email = faker.internet().emailAddress();
        String password = "1234567";
        String confirm = password;
        signupPage.signUpForm(name, email, password, confirm);
        homePage.waitForSignupImportant();
        homePage.getCloseDialogBtn().click();
        homePage.clickMyProfilTabButton();
    }
    @Test
    public void editsProfile() throws InterruptedException {
        signUpWithData();
        String name = faker.name().fullName();
        String phone = faker.phoneNumber().phoneNumber();
        String city = "New York";
        String country = faker.country().name();
        String twitter = "https://" + faker.internet().url();
        String gitHub =  "https://" +faker.internet().url();
        String expMessage = "Profile saved successfuly";

        profilePage.makeMyProfile(name, phone, city, country, twitter, gitHub);
        Thread.sleep(5000);

        WebElement element = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]"));
        Assert.assertTrue(element.getText().contains(expMessage));
        Assert.assertEquals(profilePage.getNameField().getAttribute("value"), name);
        Assert.assertEquals(profilePage.getPhoneField().getAttribute("value"), phone);
        Assert.assertEquals(profilePage.getCityField().getAttribute("value"), city);
        Assert.assertEquals(profilePage.getCountryField().getAttribute("value"), country);
        Assert.assertEquals(profilePage.getTwitterField().getAttribute("value"), twitter);
        Assert.assertEquals(profilePage.getUrlGitHubField().getAttribute("value"), gitHub);
    }
}


