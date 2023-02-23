package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthRoutesTests extends BaseTest {

    @Test
    public void forbidsVisitsToHomeUrlIfNotAuthenticated() {
        getloginUrl();
        Assert.assertTrue(driver.getCurrentUrl().endsWith("/login"));
    }

    @Test
    public void forbidsVisitsToProfileUrl() {
        getprofileUrl();
        Assert.assertTrue(driver.getCurrentUrl().endsWith("/login"));
    }

    @Test
    public void forbidsVisitsToAdminCitiesUrl() {
        getadminCityUrl();
        Assert.assertTrue(driver.getCurrentUrl().endsWith("/login"));
    }

    @Test
    public void forbidsVisitsToAdminUsersUrl() {
        getadminUserUrl();
        Assert.assertTrue(driver.getCurrentUrl().endsWith("/login"));
    }
}
