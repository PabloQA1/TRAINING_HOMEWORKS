package AT.hw_6;


import AT.hw_6.business_objects.User;
import AT.hw_6.utils.PropertyReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends BasePageTest {

    @Test(priority = 1)
    public void loginTest() {
        user = new User("john.smith.test.acc", "krkx[kX6/@NA(Wp");
        loginPage
                .openLoginPage()
                .logInWithUserObject(user);
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