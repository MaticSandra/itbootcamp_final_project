package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.LandingPage;

import java.time.Duration;

public abstract class BaseTest {

    protected WebDriver driver;
    protected WebDriverWait driverWait;
    protected LandingPage landingPage;
    protected Faker faker;

    @BeforeClass
    public void beforeClass() {
//        System.setProperty("webdiver.chrome.driver", "C:\\ITBootCamp\\chromedriver");
        driver = new ChromeDriver();
        landingPage = new LandingPage(driver, driverWait);
        faker = new Faker();
        driverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.get("https://vue-demo.daniel-avellaneda.com/");
    }

    public void getHomeUrl(){
        driver.navigate().to("https://vue-demo.daniel-avellaneda.com/home");
    }
    public void getprofileUrl(){
        driver.navigate().to("https://vue-demo.daniel-avellaneda.com/profile");
    }
    public void getadminCityUrl(){
        driver.navigate().to("https://vue-demo.daniel-avellaneda.com/admin/cities");
    }
    public void getadminUserUrl(){
        driver.navigate().to("https://vue-demo.daniel-avellaneda.com/admin/cities");
    }
    public void getloginUrl(){
        driver.navigate().to("https://vue-demo.daniel-avellaneda.com/login");
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
