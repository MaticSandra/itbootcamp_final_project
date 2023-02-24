package tests;

import enumClass.LanguageE;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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
        String expMessage = "Page d'atterrissage";
        Assert.assertTrue(landingPage.getHeaderMessage().getText().endsWith(expMessage));
    }

    @Test
    public void setLocaleToEs() {
        landingPage.selectLanguage(LanguageE.ES);
        String expMessage = "Página de aterrizaje";
        Assert.assertTrue(landingPage.getHeaderMessage().getText().endsWith(expMessage));
    }
}
