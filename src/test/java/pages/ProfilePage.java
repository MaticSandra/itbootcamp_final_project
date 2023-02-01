package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
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
    @FindBy(className = "btnSave")
    private WebElement saveButton;

    public ProfilePage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public WebElement getEmailField() {
        return emailField;
    }

    public void selectCity(String city){
        Select citySelect = new Select(cityField);
        citySelect.selectByVisibleText(city);
    }

    public void makeMyProfile(String name, String phone, String city, String country, String urlTwitter, String urlGitHub ){
        nameField.sendKeys(name);
        phoneField.sendKeys(phone);
        selectCity(city);
        countryField.sendKeys(country);
        twitterField.sendKeys(urlTwitter);
        urlGitHubField.sendKeys(urlGitHub);
        saveButton.click();
    }

}


