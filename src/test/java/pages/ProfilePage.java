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

    public WebElement getEmailField() {
        return emailField;
    }

    public WebElement getProfileSavedMessage() {
        return profileSavedMessage;
    }


    public void makeMyProfile(String name, String phone, String city, String country, String urlTwitter, String urlGitHub) {
        nameField.clear();
        phoneField.clear();
        cityField.clear();
        countryField.clear();
        twitterField.clear();
        urlGitHubField.clear();

        nameField.sendKeys(name);
        phoneField.sendKeys(phone);
        //cityField.sendKeys(Keys.SPACE, Keys.BACK_SPACE);
        cityField.sendKeys(Keys.CONTROL + "a");
        cityField.sendKeys(Keys.DELETE);
        cityField.sendKeys(city, Keys.ENTER);
        countryField.sendKeys(country);
        twitterField.sendKeys(urlTwitter);
      //  urlGitHubField.sendKeys(urlGitHub);

        saveButton.click();

    }


}


