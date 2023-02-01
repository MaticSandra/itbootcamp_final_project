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
import pages.LandingPage;
import pages.LoginPage;

public class AdminCitiesTests extends BaseTest{

    LandingPage landingPage;
    HomePage homePage;
    LoginPage loginPage;
    AdminCitiesPage adminCitiesPage;

    private static final String NOVISAD = "Novi Sad";

    @BeforeClass
    @Override
    public void beforeClass() {
        super.beforeClass();
        landingPage = new LandingPage(driver, driverWait);
        homePage = new HomePage(driver, driverWait);
        loginPage = new LoginPage(driver, driverWait);
        adminCitiesPage = new AdminCitiesPage(driver, driverWait);
    }

    private void clickLoginTab(){
        landingPage.clickLoginTab();
        loginPage.loginForm("admin@admin.com", "12345");
        adminCitiesPage.waitForRoute("/home");
    }

    private void clickCitiesTab(){
        homePage.clickCitiesTabButton();
        adminCitiesPage.waitForRoute("/admin/cities");
    }

    @Test(priority = 1)
    public void visitsAdminCitiesPageAndCities(){
        clickLoginTab();
        clickCitiesTab();
        Assert.assertTrue(driver.getCurrentUrl().endsWith("/admin/cities"));
    }

    @Test(priority = 2)
    public void createNewCity(){
        clickCitiesTab();
        //String cityName = "Novi Sad"; //faker.address().cityName();
        adminCitiesPage.addNewCity(NOVISAD);

        String expMessageSuccessfullySaved = "Saved successfully";
        //adminCitiesPages.waitForSavedSuccessfullyMessage();
        //Assert.assertTrue(adminCitiesPages.getSavedSuccessfullyMessage().contains(expMessageSuccessfullySaved));
    }

    @Test(priority = 3)
    public void editCity(){
        clickCitiesTab();
        adminCitiesPage.clickOnEditButtonForSearchedCity(NOVISAD);
        adminCitiesPage.editCity("- edited");

        String expMessageSuccessfullySaved = "Saved successfully";
        //adminCitiesPages.waitForSavedSuccessfullyMessage();
        //Assert.assertTrue(adminCitiesPages.getSavedSuccessfullyMessage().contains(expMessageSuccessfullySaved));
    }

}
