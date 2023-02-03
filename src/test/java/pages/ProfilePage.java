package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage extends BasePage{

    @FindBy(id = "email")
    private WebElement emailField;
    @FindBy(id = "name")
    private WebElement nameField;
    @FindBy(id = "phone")
    private WebElement phoneField;
    @FindBy(id = "city")
    private WebElement cityField;
    @FindBy(id = "country")
    private WebElement countryField;
    @FindBy(id = "urlTwitter")
    private WebElement twitterField;
    @FindBy(id = "urlGitHub")
    private WebElement urlGitHubField;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[2]/span/form/div/div/div[8]")
    private WebElement saveButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]")
    private WebElement profileSavedMessage;

    public ProfilePage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public WebElement getNameField() {
        return nameField;
    }

    public WebElement getPhoneField() {
        return phoneField;
    }

    public WebElement getCityField() {
        return cityField;
    }

    public WebElement getCountryField() {
        return countryField;
    }

    public WebElement getTwitterField() {
        return twitterField;
    }

    public WebElement getUrlGitHubField() {
        return urlGitHubField;
    }

    public WebElement getEmailField() {
        return emailField;
    }

    public WebElement getProfileSavedMessage() {
        return profileSavedMessage;
    }

    public void makeMyProfile(String name, String phone, String city, String country, String urlTwitter, String urlGitHub) throws InterruptedException {
       Thread.sleep(2000);
        phoneField.sendKeys(Keys.CONTROL + "a");
        phoneField.sendKeys(Keys.DELETE);
        cityField.sendKeys(Keys.SPACE);
        cityField.sendKeys(Keys.CONTROL + "a");
        cityField.sendKeys(city);
        cityField.sendKeys(Keys.ARROW_DOWN);
        cityField.sendKeys(Keys.ENTER);

        countryField.sendKeys(Keys.CONTROL + "a");
        countryField.sendKeys(Keys.DELETE);
        twitterField.sendKeys(Keys.CONTROL + "a");
        twitterField.sendKeys(Keys.DELETE);
        urlGitHubField.sendKeys(Keys.CONTROL + "a");
        urlGitHubField.sendKeys(Keys.DELETE);
        nameField.sendKeys(Keys.CONTROL + "a");
        nameField.sendKeys(Keys.DELETE);
        Thread.sleep(2000);
        phoneField.sendKeys(phone);
        Thread.sleep(2000);
        countryField.sendKeys(country);
        Thread.sleep(2000);
        twitterField.sendKeys(urlTwitter);
        Thread.sleep(5000);
        urlGitHubField.sendKeys(urlGitHub);
        Thread.sleep(2000);
        nameField.sendKeys(name);
        Thread.sleep(2000);
        saveButton.click();
    }

}


