package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LandingPage;
import pages.LoginPage;
import pages.ProfilePage;

public class ProfileTests extends BaseTest {

    LandingPage landingPage;

    LoginPage loginPage;

    HomePage homePage;

    ProfilePage profilePage;

    @BeforeClass
    @Override
    public void beforeClass() {
        super.beforeClass();
        landingPage = new LandingPage(driver, driverWait);
        homePage = new HomePage(driver, driverWait);
        loginPage = new LoginPage(driver, driverWait);
        profilePage = new ProfilePage(driver, driverWait);
    }

    @BeforeMethod
    @Override
    public void beforeMethod() {
        super.beforeMethod();
        landingPage.clickLoginTab();
        loginPage.loginForm("admin@admin.com","12345");
    }

    @Test
    public void editsProfile() {
        homePage.clickMyProfilTabButton();
        String name = faker.name().fullName();
        String phone = faker.phoneNumber().cellPhone();
        String city = "Bogota";
        String country = faker.country().name();
        String twitter = faker.internet().url();
        String gitHub = faker.internet().url();

        profilePage.makeMyProfile(name, phone, city, country, twitter, gitHub);

    }
}
