package tests;

import enumClass.LanguageE;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LandingPage;

public class LocaleTests extends BaseTest {
    @BeforeMethod
    public void beforeMethod() {
        super.beforeMethod();
        landingPage.getLocaleActivationButton().click();
    }

    @Test
    public void setLocaleToEn() {
        landingPage.selectLanguage(LanguageE.EN);
        String expMessage = "Landing";
        Assert.assertTrue(landingPage.getHeaderMessage().getText().endsWith(expMessage));
    }

    @Test
    public void setLocaleToFr() {
        landingPage.selectLanguage(LanguageE.FR);
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.className("display-2")));
        String expMessage = "Page d'atterrissage";
        Assert.assertTrue(landingPage.getHeaderMessage().getText().endsWith(expMessage));
    }

    @Test
    public void setLocaleToEs() {
        landingPage.selectLanguage(LanguageE.ES);
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.className("display-2")));
        String expMessage = "Página de aterrizaje";
        Assert.assertTrue(landingPage.getHeaderMessage().getText().endsWith(expMessage));
    }
}
