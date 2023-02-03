package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

    @FindBy(id = "email")
    private WebElement inputFieldEmail;

    @FindBy(id = "password")
    private WebElement inputFieldPassword;
    @FindBy(xpath = "//*[@id=\"app\"]/div/main/div/div[2]/div/div/div[3]/span/form/div/div[3]/button")
    private WebElement login;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]/ul/li")
    private WebElement errorDontExist;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]/ul/li")
    private WebElement errorWrongPass;

    public LoginPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public WebElement getInputFieldEmail() {
        return inputFieldEmail;
    }

    public WebElement getInputFieldPassword() {
        return inputFieldPassword;
    }

    public boolean getIfImLoggedIn() {
        return driver.getCurrentUrl().endsWith("/home");
    }


    public void loginForm(String email, String password) {
        inputFieldEmail.clear();
        inputFieldEmail.sendKeys(email);
        inputFieldPassword.clear();
        inputFieldPassword.sendKeys(password);
        login.click();
    }

    public String getDontExistMessage() {
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]")));
        return errorDontExist.getText();
    }

    public String getErrorWrongPassword() {
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div")));
        return errorWrongPass.getText();
    }

}
