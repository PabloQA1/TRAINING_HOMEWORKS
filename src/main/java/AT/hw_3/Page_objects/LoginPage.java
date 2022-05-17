package AT.hw_3.Page_objects;

import AT.hw_2.MailPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {


    public static final String URL = "https://account.protonmail.com/login";

    @FindBy(css = "#username")
    private WebElement userNameInputField;

    @FindBy(xpath = "//*[@id='password']")
    private WebElement passwordInputField;

    @FindBy(xpath = "//button[contains(text(),'Sign in')]")
    private WebElement signInButton;

    @FindBy(xpath = "//strong[contains(text(),'Sign in')]")
    private WebElement loginMessage;

    public LoginPage(WebDriver driver) {
        super(driver);

        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public LoginPage openLoginPage() {
        openPage(URL);
        return this;
    }

    public MailPage logIn(String accountName, String password) {
        userNameInputField.sendKeys(accountName);
        passwordInputField.sendKeys(password);
        signInButton.click();
        return new MailPage(driver);
    }
}
