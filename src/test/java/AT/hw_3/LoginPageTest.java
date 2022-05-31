package AT.hw_3;

import AT.hw_3.utils.PropertyReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends BasePageTest {

    @Test(priority = 1)
    public void loginTest() {
        loginPage
                .openLoginPage()
                .logIn(System.getenv().getOrDefault("accountName", PropertyReader.getProperty("accountName")),
                        System.getenv().getOrDefault("password", PropertyReader.getProperty("password")));
        Assert.assertTrue(mailPage.checkTheSuccessfulLogin());
    }

    @Test(priority = 2)
    public void signOutTest() {
        loginPage
                .openLoginPage()
                .logIn(System.getenv().getOrDefault("accountName", PropertyReader.getProperty("accountName")),
                        System.getenv().getOrDefault("password", PropertyReader.getProperty("password")))
                .signOut();
        Assert.assertTrue(loginPage.verifyThatIsLoginPage());
    }
}