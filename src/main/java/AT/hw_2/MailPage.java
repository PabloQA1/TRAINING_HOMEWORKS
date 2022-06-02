package AT.hw_2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MailPage extends BasePage {
    public MailPage(WebDriver driver) {
        super(driver);
    }

    private static final By NEW_MESSAGE_BUTTON = By.xpath("//*[@data-testid='sidebar:compose']");
    private static final By EMAIL_ADDRESS_INPUT_FIELD = By.xpath("//*[@data-testid='composer:to']");
    private static final By SUBJECT_INPUT_FIELD = By.xpath("//*[@data-testid='composer:subject']");
    private static final By MESSAGE_TEXT_AREA_IFRAME = By.xpath("//iframe[@title='Email composer']");
    private static final By MESSAGE_TEXT_AREA = By.xpath("//*[@id='rooster-editor']");
    private static final By DRAFTS_BUTTON = By.xpath("//span[contains(text(),'Drafts')]");
    private static final By EMERGING_SAVED_INFORMATION = By.xpath("//span[contains(text(),'Saved')]");
    private static final By CLOSE_POP_UP_NEW_MESSAGE_WINDOW_BUTTON = By.xpath("//*[@data-testid='composer:close-button']");
    private static final String DRAFT_LETTERS_LIST =
            ("//*[@class='relative items-column-list relative']//*" + "[contains(text(),'%s')]");
    private static final By EMAIL_ADDRESS_INPUT_FIELD_IN_DRAFTS = By.cssSelector("span[class='max-w100 text-ellipsis']");
    private static final By SEND_EMAIL_BUTTON = By.xpath("//*[@data-testid='composer:send-button']");
    private static final By SENT_BUTTON = By.xpath(" //span[contains(text(),'Sent')]");
    private static final By USER_DROP_DOWN_MENU = By.cssSelector(".user-dropdown-displayName");
    private static final By SIGN_OUT_BUTTON = By.xpath("//button[normalize-space()='Sign out']");

    public boolean checkTheSuccessfulLogin() {
        return driver.findElement(NEW_MESSAGE_BUTTON).isDisplayed();
    }

    public MailPage createNewEmailAndSaveItInTheDrafts(String email, String subject, String message) {
        driver.findElement(NEW_MESSAGE_BUTTON).click();
        driver.findElement(EMAIL_ADDRESS_INPUT_FIELD).sendKeys(email);
        driver.findElement(SUBJECT_INPUT_FIELD).sendKeys(subject);
        driver.switchTo().frame(driver.findElement(MESSAGE_TEXT_AREA_IFRAME));
        driver.findElement(MESSAGE_TEXT_AREA).sendKeys(message);
        driver.switchTo().defaultContent();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(EMERGING_SAVED_INFORMATION));
        driver.findElement(CLOSE_POP_UP_NEW_MESSAGE_WINDOW_BUTTON).click();
        return this;
    }

    public MailPage openDrafts() {
        driver.findElement(DRAFTS_BUTTON).click();
        return this;
    }

    public boolean verifyThatMailInDraftsFolderBySubject(String subject) {
        return driver.findElement(By.xpath(String.format(DRAFT_LETTERS_LIST, subject))).isDisplayed();
    }

    public MailPage openSavedLetterBySubject(String subject) {
        driver.findElement(By.xpath(String.format(DRAFT_LETTERS_LIST, subject))).click();
        return this;
    }

    public boolean verifyEmailInSavedInDraftsLetterContent(String email) {
        return driver.findElement(EMAIL_ADDRESS_INPUT_FIELD_IN_DRAFTS).getText().contains(email);
    }

    public boolean verifyMessageInSavedInDraftsLetterContent(String message) {
        driver.switchTo().frame(driver.findElement(MESSAGE_TEXT_AREA_IFRAME));
        return driver.findElement(MESSAGE_TEXT_AREA).getText().contains(message);
    }

    public MailPage clickOnTheSendButtonOnEmailModalWindow() {
        driver.findElement(SEND_EMAIL_BUTTON).click();
        return this;
    }

    public boolean verifyThatSendMailIsNotDisplayedInDrafts(String subject) {
        return driver.findElement(By.xpath(String.format(DRAFT_LETTERS_LIST, subject))).isDisplayed();
    }

    public MailPage openSent() {
        driver.findElement(SENT_BUTTON).click();
        return this;
    }

    public boolean verifyThatSendMailIsDisplayedInSent(String subject) {
        return driver.findElement(By.xpath(String.format(DRAFT_LETTERS_LIST, subject))).isDisplayed();
    }

    public void signOut() {
        driver.findElement(USER_DROP_DOWN_MENU).click();
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(SIGN_OUT_BUTTON)).click();
    }
}
