package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
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
        String phone = faker.phoneNumber().phoneNumber();
        String city = "Chicago";
        String country = faker.country().name();
        String twitter = faker.internet().url();
        String gitHub = faker.internet().url();
        String expMessage = "Profile saved successfuly";

        profilePage.makeMyProfile(name, phone, city, country, twitter, gitHub);

        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]"))); //nije jos stigao ovde
///html/body/div/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]/text()
        System.out.println(profilePage.getProfileSavedMessage());
        WebElement element = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]"));
        Assert.assertEquals(element.getText(), expMessage);
    }

}

