package AT.hw_2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public static final String URL = "https://account.protonmail.com/login";
    private static final By USER_NAME_INPUT_FIELD = By.cssSelector("#username");
    private static final By PASSWORD_INPUT_FIELD = By.xpath("//*[@id='password']");
    private static final By SIGN_IN_BUTTON = By.xpath("//button[contains(text(),'Sign in')]");
    private static final By LOG_IN_MESSAGE = By.xpath("//strong[contains(text(),'Sign in')]");

    public LoginPage openLoginPage() {
        openPage(URL);
        return this;
    }

    public MailPage logIn(String accountName, String password) {
        driver.findElement(USER_NAME_INPUT_FIELD).sendKeys(accountName);
        driver.findElement(PASSWORD_INPUT_FIELD).sendKeys(password);
        driver.findElement(SIGN_IN_BUTTON).click();
        return new MailPage(driver);
    }

    public boolean verifyThatIsLoginPage() {
        return driver.findElement(LOG_IN_MESSAGE).isDisplayed();
    }
}
