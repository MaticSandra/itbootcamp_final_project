package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignupPage extends BasePage {
    @FindBy(id = "name")
    private WebElement inputSignupName;
    @FindBy(id = "email")
    private WebElement inputSignupEmail;
    @FindBy(id = "password")
    private WebElement inputPassword;
    @FindBy(id = "confirmPassword")
    private WebElement confirmPassword;
    @FindBy(xpath = "//*[@id=\"app\"]/div/main/div/div[2]/div/div/div[2]/span/form/div/div[5]/button")
    private WebElement signMeUpButton;
    @FindBy(className = "container")
    private WebElement form;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[3]/div/div/div/div/div[1]/ul/li")
    private WebElement errorAlreadyExist;

    public SignupPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public WebElement getInputSignupName() {
        return inputSignupName;
    }

    public WebElement getInputSignupEmail() {
        return inputSignupEmail;
    }

    public WebElement getInputPassword() {
        return inputPassword;
    }

    public WebElement getConfirmPassword() {
        return confirmPassword;
    }

    public WebElement getSignMeUpButton() {
        return signMeUpButton;
    }

    public void signUpForm(String name, String email, String password, String confirmPasswordInp) {
        inputSignupName.sendKeys(name);
        inputSignupEmail.sendKeys(email);
        inputPassword.sendKeys(password);
        confirmPassword.sendKeys(confirmPasswordInp);
        signMeUpButton.click();
    }

    public String getMessageAlreadyExist() {
        return errorAlreadyExist.getText();
    }

}
