package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {

    @FindBy(className = "btnProfile")
    private WebElement myProfilTabButton;

    @FindBy(className = "btnAdmin")
    private WebElement adminTabButton;

    @FindBy(className = "btnLogout")
    private WebElement logoutTabButton;

    @FindBy(className = "btnAdminCities")
    private WebElement cities;

    @FindBy(className = "btnClose")
    private WebElement closeDialogBtn;

    @FindBy(className = "v-card__title")
    private WebElement importantMessage;


    public HomePage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public void clickCitiesTabButton() {
        adminTabButton.click();
        cities.click();
    }

    public boolean isDisplayed() {
        return logoutTabButton.isDisplayed();
    }

    public void clickLogout() {
        logoutTabButton.click();
    }

    public WebElement getLogoutTabButton() {
        return logoutTabButton;
    }

    public String getImportantMessage() {
        return importantMessage.getText();
    }

    public void waitForSignupImportant() {
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.className("v-card__title")));
    }

    public WebElement getCloseDialogBtn() {
        return closeDialogBtn;
    }
    public void clickMyProfilTabButton(){
        myProfilTabButton.click();
    }

}
