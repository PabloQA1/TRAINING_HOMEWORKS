package AT.hw_5.page_objects;

import AT.hw_5.business_objects.User;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage extends BasePage {

    public static final String LOGIN_PAGE_URL = "login";
    private final SelenideElement userNameInputField = $(By.cssSelector("#username"));
    private final SelenideElement passwordInputField = $(By.xpath("//*[@id='password']"));
    private final SelenideElement signInButton = $(By.xpath("//button[contains(text(),'Sign in')]"));
    private final SelenideElement loginMessage = $(By.xpath("//strong[contains(text(),'Sign in')]"));

    public LoginPage openLoginPage() {
        openPage(LOGIN_PAGE_URL);
        return this;
    }

    public MailPage logInWithUserObject(User user) {
        userNameInputField.sendKeys(user.getAccountName());
        passwordInputField.sendKeys(user.getPassword());
        signInButton.click();
        return new MailPage();
    }

    public boolean verifyThatIsLoginPage() {
        return loginMessage.shouldBe(visible).isDisplayed();
    }
}
