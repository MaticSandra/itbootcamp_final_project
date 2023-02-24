package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class AdminCitiesPage extends BasePage {

    @FindBy(className = "btnNewItem")
    private WebElement newItemButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[2]/table/tbody/tr")
    private List<WebElement> cityList;

    @FindBy(id = "search")
    private WebElement searchInput;

    @FindBy(id = "name")
    private WebElement nameInput;

    @FindBy(className = "btnSave")
    private WebElement saveButton;

    @FindBy(className = "text--lighten3")
    private WebElement deleteDialogButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]")
    private WebElement notificationDeleteCity;

    public AdminCitiesPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }


    public String getFirstRowCityName() {
        if (cityList.size() > 0) {
            return cityList.get(0).findElement(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[2]/table/tbody/tr[1]/td[2]")).getText();
        } else {
            return "";
        }
    }

    public String clickOnEditButtonForSearchedCity() {
        WebElement editButton = cityList.get(0).findElement(By.xpath("//*[@id=\"edit\"]"));
        editButton.click();
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.className("dlgNewEditItem")));
        nameInput.sendKeys(" - " + nameInput.getText() + " edited");
        saveButton.click();
        return nameInput.getText();
    }

    public void clickOnDeleteButtonForSearchedCity() {
        WebElement deleteRowButton = cityList.get(0).findElement(By.id("delete"));
        deleteRowButton.click();
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.className("text--lighten3")));
        deleteDialogButton.click();
    }

    public void addNewCity(String cityName) {
        newItemButton.click();
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.className("dlgNewEditItem")));
        nameInput.sendKeys(cityName);
        saveButton.click();
    }

    public void waitForNotificationMessage() {
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]")));
    }

    public String getNotificationMessage() {
        return notificationDeleteCity.getText();
    }
    public String successfullySaved(){
        return "Saved successfully";
    }
    public String successfullyDeleted(){
        return "Deleted successfully";
    }
    public void inputSearchCity(String searchCity) {
        searchInput.sendKeys(Keys.CONTROL + "a");
        searchInput.sendKeys(Keys.DELETE);
        searchInput.sendKeys(searchCity);
    }
}
