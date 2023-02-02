package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LandingPage;

public class AuthRoutesTests extends BaseTest {
    LandingPage landingPage;

    @BeforeClass
    @Override
    public void beforeClass() {
        super.beforeClass();
        landingPage = new LandingPage(driver, driverWait);
    }

    @BeforeMethod
    @Override
    public void beforeMethod() {
        super.beforeMethod();
    }

    @Test
    public void forbidsVisitsToHomeUrlIfNotAuthenticated() {
//      driver.get("https://vue-demo.daniel-avellaneda.com/login");
        driver.navigate().to("https://vue-demo.daniel-avellaneda.com/login");
        Assert.assertTrue(driver.getCurrentUrl().endsWith("/login"));

    }

    @Test
    public void forbidsVisitsToProfileUrlIfNotAuthenticated() {
//      driver.get("https://vue-demo.daniel-avellaneda.com/profile");
        driver.navigate().to("https://vue-demo.daniel-avellaneda.com/profile");
        Assert.assertTrue(driver.getCurrentUrl().endsWith("/login"));
    }

    @Test
    public void forbidsVisitsToAdminCitiesUrlIfNotAuthenticated() {
//      driver.get("https://vue-demo.daniel-avellaneda.com/admin/cities");
        driver.navigate().to("https://vue-demo.daniel-avellaneda.com/admin/cities");
        Assert.assertTrue(driver.getCurrentUrl().endsWith("/login"));
    }

    @Test
    public void forbidsVisitsToAdminUsersUrlIfNotAuthenticated() {
//      driver.get("https://vue-demo.daniel-avellaneda.com/admin/users");
        driver.navigate().to("https://vue-demo.daniel-avellaneda.com/admin/users");
        Assert.assertTrue(driver.getCurrentUrl().endsWith("/login"));
    }
}
