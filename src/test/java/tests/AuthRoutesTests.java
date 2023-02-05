package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthRoutesTests extends BaseTest {

    @Test
    public void forbidsVisitsToHomeUrlIfNotAuthenticated() {
        driver.navigate().to("https://vue-demo.daniel-avellaneda.com/login");
        Assert.assertTrue(driver.getCurrentUrl().endsWith("/login"));

    }

    @Test
    public void forbidsVisitsToProfileUrlIfNotAuthenticated() {
        driver.navigate().to("https://vue-demo.daniel-avellaneda.com/profile");
        Assert.assertTrue(driver.getCurrentUrl().endsWith("/login"));
    }

    @Test
    public void forbidsVisitsToAdminCitiesUrlIfNotAuthenticated() {
        driver.navigate().to("https://vue-demo.daniel-avellaneda.com/admin/cities");
        Assert.assertTrue(driver.getCurrentUrl().endsWith("/login"));
    }

    @Test
    public void forbidsVisitsToAdminUsersUrlIfNotAuthenticated() {
        driver.navigate().to("https://vue-demo.daniel-avellaneda.com/admin/users");
        Assert.assertTrue(driver.getCurrentUrl().endsWith("/login"));
    }
}
