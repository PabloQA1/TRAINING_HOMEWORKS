package AT.hw_2;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends BasePageTest {

    @Test(priority = 1)
    public void loginTest() {
        loginPage
                .openLoginPage()
                .logIn("john.smith.test.acc", "krkx[kX6/@NA(Wp");
        Assert.assertTrue(mailPage.checkTheSuccessfulLogin());
    }

    @Test(priority = 2)
    public void signOutTest() {
        loginPage
                .openLoginPage()
                .logIn("john.smith.test.acc", "krkx[kX6/@NA(Wp")
                .signOut();
        Assert.assertTrue(loginPage.verifyThatIsLoginPage());
    }
}