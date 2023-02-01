package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LandingPage extends BasePage{

    @FindBy(xpath = "//a[@href=\"/login\"]")
    private WebElement logginTabButton;

    @FindBy(xpath = "//a[@href=\"/signup\"]")
    private WebElement signupTabButton;

    public LandingPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public void clickLoginTab(){
        logginTabButton.click();
    }

    public void clickSignupTab(){
        signupTabButton.click();
    }

    public WebElement getLogginButton() {
        return logginTabButton;
    }

}
