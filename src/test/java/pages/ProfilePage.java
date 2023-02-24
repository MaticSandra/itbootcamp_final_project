package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage extends BasePage {

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
    private WebElement gitHubField;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[2]/span/form/div/div/div[8]")
    private WebElement saveButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]")
    private WebElement profileSavedMessage;

    public ProfilePage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }


    public String getNameField() {
        return nameField.getAttribute("value");
    }

    public String getPhoneField() {
        return phoneField.getAttribute("value");
    }

    public String getCityField() {
        return cityField.getAttribute("value");
    }

    public String getCountryField() {
        return countryField.getAttribute("value");
    }

    public String getTwitterField() {
        return twitterField.getAttribute("value");
    }

    public String getUrlGitHubField() {
        return gitHubField.getAttribute("value");
    }

    public String getProfileSavedMessage() {
        return profileSavedMessage.getText();
    }

    public void enterNameProfile(String name) {
        nameField.click();
        nameField.sendKeys(Keys.CONTROL + "a");
        nameField.sendKeys(Keys.DELETE);
        nameField.sendKeys(name);
    }

    public void enterPhoneNumberProfile(String number) {
        phoneField.click();
        phoneField.sendKeys(Keys.CONTROL + "a");
        phoneField.sendKeys(Keys.DELETE);
        phoneField.sendKeys(number);
    }

    public void enterCityProfile(String city) {
        cityField.click();
        cityField.sendKeys(Keys.SPACE);
        cityField.sendKeys(Keys.CONTROL + "a");
        cityField.sendKeys(city);
        cityField.sendKeys(Keys.ARROW_DOWN);
        cityField.sendKeys(Keys.ENTER);
    }

    public void enterCountryProfile(String country) {
        countryField.click();
        countryField.sendKeys(Keys.CONTROL + "a");
        countryField.sendKeys(Keys.DELETE);
        countryField.sendKeys(country);
    }

    public void enterTwitterProfile(String twitter) {
        twitterField.click();
        twitterField.sendKeys(Keys.CONTROL + "a");
        twitterField.sendKeys(Keys.DELETE);
        twitterField.sendKeys(twitter);
    }

    public void entergitHubProfile(String github) {
        gitHubField.click();
        gitHubField.sendKeys(Keys.CONTROL + "a");
        gitHubField.sendKeys(Keys.DELETE);
        gitHubField.sendKeys(github);
    }

    public void makeMyProfile(String name, String phone, String city, String country, String twitter, String github) throws InterruptedException {
        enterNameProfile(name);
        enterPhoneNumberProfile(phone);
        enterCityProfile(city);
        enterCountryProfile(country);
        enterTwitterProfile(twitter);
        entergitHubProfile(github);
        saveButton.click();
    }
}


