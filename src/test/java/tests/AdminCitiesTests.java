package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AdminCitiesPage;
import pages.HomePage;
import pages.LandingPage;
import pages.LoginPage;

public class AdminCitiesTests extends BaseTest {

//    LandingPage landingPage;
    HomePage homePage;
    LoginPage loginPage;
    AdminCitiesPage adminCitiesPage;

    private String globalCityAddEdit = "";

    @BeforeClass
    @Override
    public void beforeClass() {
        super.beforeClass();
//      landingPage = new LandingPage(driver, driverWait);
        homePage = new HomePage(driver, driverWait);
        loginPage = new LoginPage(driver, driverWait);
        adminCitiesPage = new AdminCitiesPage(driver, driverWait);
    }

    @BeforeMethod
    public void beforeMethod() {
        super.beforeMethod();
        landingPage.clickLoginTab();
        loginPage.loginForm("admin@admin.com", "12345");
        homePage.clickCitiesTabButton();
    }

    @AfterMethod
    public void afterMethod() {
        if (homePage.isLogoutDisplayed()) {
            homePage.clickLogoutButton();
        }
    }

    @Test(priority = 1)
    public void visitsAdminCitiesPageAndCitiesTest() {
        Assert.assertTrue(driver.getCurrentUrl().endsWith("/admin/cities"));
    }

    @Test(priority = 2)
    public void createNewCityTest() {
        globalCityAddEdit = faker.address().cityName();
        adminCitiesPage.addNewCity(globalCityAddEdit);
        String expMessageSuccessfullySaved = "Saved successfully";
        Assert.assertTrue(adminCitiesPage.getNotificationMessage().contains(expMessageSuccessfullySaved));
    }

    @Test(priority = 3)
    public void editCityTest() {
        adminCitiesPage.inputSearchCity(globalCityAddEdit);
        globalCityAddEdit = adminCitiesPage.clickOnEditButtonForSearchedCity();
        String expMessageSuccessfullySaved = "Saved successfully";
        Assert.assertTrue(adminCitiesPage.getNotificationMessage().contains(expMessageSuccessfullySaved));
    }

    @Test(priority = 4)
    public void searchCityTest() {
        adminCitiesPage.inputSearchCity(globalCityAddEdit);
        Assert.assertTrue(adminCitiesPage.getFirstRowCityName().contains(globalCityAddEdit));
    }

    @Test(priority = 5)
    public void deleteCityTest () {
        adminCitiesPage.inputSearchCity(globalCityAddEdit);
        Assert.assertTrue(adminCitiesPage.getFirstRowCityName().contains(globalCityAddEdit));
        adminCitiesPage.clickOnDeleteButtonForSearchedCity();

        String expMessageSuccessfullySaved = "Deleted successfully";
        adminCitiesPage.waitForNotificationMessage();
        Assert.assertTrue(adminCitiesPage.getNotificationMessage().contains(expMessageSuccessfullySaved));
    }
}



