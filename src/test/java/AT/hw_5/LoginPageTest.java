package AT.hw_5;

import AT.hw_5.business_objects.User;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends BasePageTest{

    @Test
    public void loginTest() {
        user = new User("john.smith.test.acc", "krkx[kX6/@NA(Wp");
        loginPage
                .openLoginPage()
                .logInWithUserObject(user);
        Assert.assertTrue(mailPage.checkTheSuccessfulLogin());
    }
}