package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AdminCitiesPage;
import pages.HomePage;
import pages.LoginPage;

public class AdminCitiesTests extends BaseTest {

    HomePage homePage;
    LoginPage loginPage;
    AdminCitiesPage adminCitiesPage;

    private String globalCityAddEdit = "";

    @BeforeClass
    @Override
    public void beforeClass() {
        super.beforeClass();
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
        homePage.clickLogoutButton();
    }

    @Test
    public void visitsAdminCitiesPageAndCitiesTest() {
        Assert.assertTrue(driver.getCurrentUrl().endsWith("/admin/cities"));
    }

    @Test
    public void createAndSearchCityTest() {
        globalCityAddEdit = faker.address().cityName();
        adminCitiesPage.addNewCity(globalCityAddEdit);
        Assert.assertTrue(adminCitiesPage.getNotificationMessage().contains(adminCitiesPage.successfullySaved()));
        adminCitiesPage.inputSearchCity(globalCityAddEdit);
        Assert.assertTrue(adminCitiesPage.getFirstRowCityName().contains(globalCityAddEdit));
    }

    @Test(dependsOnMethods = "createAndSearchCityTest")
    public void editCityTest() {
        adminCitiesPage.inputSearchCity(globalCityAddEdit);
        globalCityAddEdit = adminCitiesPage.clickOnEditButtonForSearchedCity();
        Assert.assertTrue(adminCitiesPage.getNotificationMessage().contains(adminCitiesPage.successfullySaved()));
    }

    @Test(dependsOnMethods = "editCityTest")
    public void searchCityTest() {
        adminCitiesPage.inputSearchCity(globalCityAddEdit);
        Assert.assertTrue(adminCitiesPage.getFirstRowCityName().contains(globalCityAddEdit));
    }

    @Test(dependsOnMethods = "editCityTest")
    public void deleteCityTest() {
        adminCitiesPage.inputSearchCity(globalCityAddEdit);
        Assert.assertTrue(adminCitiesPage.getFirstRowCityName().contains(globalCityAddEdit));
        adminCitiesPage.clickOnDeleteButtonForSearchedCity();
        adminCitiesPage.waitForNotificationMessage();
        Assert.assertTrue(adminCitiesPage.getNotificationMessage().contains(adminCitiesPage.successfullyDeleted()));
    }

    @Test
    public void createSearchAndEditCity() {
        createAndSearchCityTest();
        globalCityAddEdit = adminCitiesPage.clickOnEditButtonForSearchedCity();
        Assert.assertTrue(adminCitiesPage.getNotificationMessage().contains(adminCitiesPage.successfullySaved()));
    }
}




