package pages;

import enumClass.LanguageE;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LandingPage extends BasePage {

    @FindBy(xpath = "//a[@href='/login']")
    private WebElement logginTabButton;

    @FindBy(xpath = "//a[@href='/signup']")
    private WebElement signupTabButton;

    @FindBy(className = "btnLocaleActivation")
    private WebElement localeActivationButton;

    @FindBy(className = "btnES")
    private WebElement selectEsLanguage;

    @FindBy(className = "btnEN")
    private WebElement selectEnLanguage;

    @FindBy(className = "btnFR")
    private WebElement selectFrLanguage;

    @FindBy(className = "btnCN")
    private WebElement selectCnLanguage;

    @FindBy(className = "btnUA")
    private WebElement selectUALanguage;

    @FindBy(className = "display-2")
    private WebElement headerMessage;

    public LandingPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public WebElement getLocaleActivationButton() {
        return localeActivationButton;
    }

    public WebElement getHeaderMessage() {
        return headerMessage;
    }

    public void clickLoginTab() {
        logginTabButton.click();
    }

    public void clickSignupTab() {
        signupTabButton.click();
    }

    public WebElement getLogginButton() {
        return logginTabButton;
    }

    public void selectLanguage(LanguageE languageE) {
        switch(languageE){
            case EN:
                selectEnLanguage.click();
                break;
            case ES:
                selectEsLanguage.click();
                break;
            case FR:
                selectFrLanguage.click();
                break;
            case CN:
                selectCnLanguage.click();
                break;
            case UA:
                selectUALanguage.click();
                break;
        }
    }

}
