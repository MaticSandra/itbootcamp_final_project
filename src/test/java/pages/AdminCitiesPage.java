package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminCitiesPage extends BasePage{

    @FindBy(className = "btnLogout")
    private WebElement logoutButton;

    @FindBy(className = "btnNewItem")
    private WebElement newItemButton;

    @FindBy(className = "dlgNewEditItem")
    private WebElement newItemForm;

    @FindBy(id = "name")
    private WebElement nameInput;

    @FindBy(className = "btnSave")
    private WebElement saveButton;

    @FindBy(className = "v-snack__content")
    private WebElement savedSuccessfullyMessage;

    public AdminCitiesPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public boolean isDisplayed(){
        return logoutButton.isDisplayed();
    }

    public void addNewCity(String cityName){
        newItemButton.click();
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.className("dlgNewEditItem")));
        nameInput.sendKeys(cityName);
        saveButton.click();
    }

    public void waitForSavedSuccessfullyMessage(){
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.className("v-snack__content")));
    }

    public String getSavedSuccessfullyMessage() {
        return savedSuccessfullyMessage.getText();
    }

}
