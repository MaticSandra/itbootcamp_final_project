package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AdminCitiesPage;
import pages.HomePage;
import pages.LoginPage;

public class AdminCitiesTests extends BaseTest{

    HomePage homePage;
    LoginPage loginPage;
    AdminCitiesPage adminCitiesPage;

    @BeforeClass
    @Override
    public void beforeClass() {
        super.beforeClass();
        homePage = new HomePage(driver, driverWait);
        loginPage = new LoginPage(driver, driverWait);
        adminCitiesPage = new AdminCitiesPage(driver, driverWait);
    }

    @BeforeMethod
    @Override
    public void beforeMethod() {
        super.beforeMethod();
        homePage.clickLoginTab();
    }
    @Test
    public void visitsAdminCitiesPageAndCities(){
        loginPage.loginForm("admin@admin.com", "12345");
        homePage.clickCitiesTabButton();
        adminCitiesPage.waitForRoute("/admin/cities");
        Assert.assertTrue(driver.getCurrentUrl().endsWith("/admin/cities"));
    }

    @Test
    public void createNewCity(){
        loginPage.loginForm("admin@admin.com", "12345");
        homePage.clickCitiesTabButton();
        adminCitiesPage.waitForRoute("/admin/cities");
        String cityName = faker.address().cityName();
        adminCitiesPage.addNewCity(cityName);

        String expMessageSuccessfullySaved = "Saved successfully";
        //adminCitiesPages.waitForSavedSuccessfullyMessage();
        //Assert.assertTrue(adminCitiesPages.getSavedSuccessfullyMessage().contains(expMessageSuccessfullySaved));
    }

    @Test
    public void editCity(){

    }

    /*@AfterMethod
    public void afterMethod() {
        if (loginPage.getIfImLoggedIn()) {
            homePage.clickLogout();
        }
    }*/

}
