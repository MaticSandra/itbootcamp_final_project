package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class AdminCitiesPage extends BasePage {

    @FindBy(className = "btnLogout")
    private WebElement logoutButton;

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
    private WebElement notificationMessage;

    public AdminCitiesPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public String getFirstRowCityName() {
        if (cityList.size() > 0) {
            return cityList.get(0).findElement(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[2]/table/tbody/tr[1]/td[2]")).getText();
            //List<WebElement> allTdElementsInRow = cityList.get(0).findElements(By.tagName("td"));
            //WebElement cityNameElement = allTdElementsInRow.get(1);
            //return cityNameElement.getText();
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
        WebElement deleteRowButton = cityList.get(0).findElement(By.xpath("//*[@id=\"delete\"]"));
        deleteRowButton.click();
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.className("v-dialog--active")));
        deleteDialogButton.click();
    }

//    public void clickOnEditButtonForSearchedCity(String searchCity) {
//        for (WebElement row : cityList) {
//            List<WebElement> allTdInRow = row.findElements(By.tagName("tr"));
//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//            WebElement editButton = allTdInRow.get(0).findElement(By.id("edit"));
//            WebElement cityNameTd = allTdInRow.get(1);
//            String cityTd = cityNameTd.getText(); ////*[@id="app"]/div[1]/main/div/div[2]/div/div[1]/div[2]/table/tbody/tr/td[2]
//
//            if (cityTd.equals(searchCity)) {
//                editButton.click();
////                driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.className("dlgNewEditItem")));
//                //globalCityAddEdit = globalCityAddEdit + " - " + nameInput.getText() + addCityText;
//                nameInput.sendKeys( "-", nameInput.getText() + " edited ");
//                saveButton.click();
//                return;
//            }
//        }
//    }



    public void addNewCity(String cityName) {
        newItemButton.click();
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.className("dlgNewEditItem")));
        nameInput.sendKeys(cityName);
        saveButton.click();
    }

    public void waitForNotificationMessage() {
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.className("v-snack")));
    }

    public String getNotificationMessage() {
        return notificationMessage.getText();
    }

    public void inputSearchCity(String searchCity){
        searchInput.sendKeys(searchCity);
    }

}
