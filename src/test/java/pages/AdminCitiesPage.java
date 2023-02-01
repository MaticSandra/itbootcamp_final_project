package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class AdminCitiesPage extends BasePage{

    @FindBy(className = "btnLogout")
    private WebElement logoutButton;

    @FindBy(className = "btnNewItem")
    private WebElement newItemButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[2]/table/tbody/tr")
    private List<WebElement> cityList;

    @FindBy(id = "search")
    private WebElement search;

    /*@FindBy(className = "dlgNewEditItem")
    private WebElement newEditForm;*/

    @FindBy(id = "name")
    private WebElement nameInput;

    @FindBy(className = "btnSave")
    private WebElement saveButton;

    @FindBy(className = "v-snack__content")
    private WebElement savedSuccessfullyMessage;

    public AdminCitiesPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public void clickOnEditButtonForSearchedCity(String searchCity) {
        for (WebElement row : cityList) {
//            WebElement cityName = row.findElement(By.cssSelector("td[2]"));
            WebElement cityName = row.findElement(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[2]/table/tbody/tr[1]/td[2]"));
            if (cityName.getText().contains(searchCity)) {
                WebElement editButton = row.findElement(By.id("edit"));
                editButton.click();
            }
        }
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

    public void editCity(String editText){
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.className("dlgNewEditItem")));
        nameInput.sendKeys(nameInput.getText() + editText);
        saveButton.click();
    }

    public void waitForSavedSuccessfullyMessage(){
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.className("v-snack__content")));
    }

    public String getSavedSuccessfullyMessage() {
        return savedSuccessfullyMessage.getText();
    }

}
