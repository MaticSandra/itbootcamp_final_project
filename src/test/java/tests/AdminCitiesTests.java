package tests;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
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

import java.util.Objects;

public class AdminCitiesTests extends BaseTest {

    LandingPage landingPage;
    HomePage homePage;
    LoginPage loginPage;
    AdminCitiesPage adminCitiesPage;

    private String globalCityAddEdit = "";

    @BeforeClass
    @Override
    public void beforeClass() {
        super.beforeClass();
        landingPage = new LandingPage(driver, driverWait);
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

//    private void clickLoginTab() {
//        landingPage.clickLoginTab();
//        loginPage.loginForm("admin@admin.com", "12345");
//        adminCitiesPage.waitForRoute("/home");
//    }

//    private void clickCitiesTab() {
//        homePage.clickCitiesTabButton();
//        adminCitiesPage.waitForRoute("/admin/cities");
//    }

        @Test
        public void visitsAdminCitiesPageAndCitiesTest () {
            Assert.assertTrue(driver.getCurrentUrl().endsWith("/admin/cities"));
        }

        @Test()
        public void createNewCityTest () {
            globalCityAddEdit = faker.address().cityName();
            adminCitiesPage.addNewCity(globalCityAddEdit);
            String expMessageSuccessfullySaved = "Saved successfully";
            Assert.assertTrue(adminCitiesPage.getSavedSuccessfullyMessage().getText().contains(expMessageSuccessfullySaved));
        }

        @Test()
        public void editCityTest () {
            adminCitiesPage.clickOnEditButtonForSearchedCity(globalCityAddEdit, " - edited");
            String expMessageSuccessfullySaved = "Saved successfully";
            Assert.assertEquals(adminCitiesPage.getSavedSuccessfullyMessage(), expMessageSuccessfullySaved);
        }

        @Test()
        public void searchCityTest () {
            adminCitiesPage.inputSearchCity(globalCityAddEdit);
            Assert.assertEquals(adminCitiesPage.getFirstRowCityName(), globalCityAddEdit);
        }

        @Test()
        public void deleteCityTest () {
        }

        @AfterMethod
        public void afterMethod() {
        if (loginPage.getIfImLoggedIn()) {
            homePage.clickLogout();
        }
    }

}


