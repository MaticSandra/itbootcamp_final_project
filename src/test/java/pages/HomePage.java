package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage{

    @FindBy(xpath = "//*[@id=\"app\"]/div/div/header/div/div[3]/a[3]")
    private WebElement logginButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/header/div/div[3]/button[2]/span")
    private WebElement logOutButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div/div/header/div/div[3]/a[4]/span")
    private WebElement signupButton;

    public WebElement getLogginButton() {
        return logginButton;
    }

    public WebElement getLogOutButton() {
        return logOutButton;
    }

    public HomePage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }
    public void clickLogin(){
         logginButton.click();
    }
    public boolean isDisplayed(){
       return logOutButton.isDisplayed();
    }

    public void clickLogout(){
        logOutButton.click();
    }
    public void clickSignup(){
        signupButton.click();
    }

}
