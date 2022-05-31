package AT.hw_3.Page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MailPage extends BasePage {

    @FindBy(xpath = "//*[@data-testid='sidebar:compose']")
    private WebElement createNewMessageButton;

    @FindBy(xpath = "//*[@data-testid='composer:to']")
    private WebElement emailAddressInputField;

    @FindBy(xpath = "//*[@data-testid='composer:subject']")
    private WebElement subjectInputField;

    @FindBy(xpath = "//iframe[@title='Email composer']")
    private WebElement messageTextAreaIframe;

    @FindBy(xpath = "//*[@id='rooster-editor']")
    private WebElement messageTextArea;

    @FindBy(xpath = "//span[contains(text(),'Drafts')]")
    private WebElement draftsButton;

    @FindBy(xpath = "//span[contains(text(),'Saved')]")
    private WebElement emergingSavedInformation;

    @FindBy(xpath = "//*[@data-testid='composer:close-button']")
    private WebElement closePopUpNewMessageWindowButton;

    @FindBy(xpath = "//*[@class='relative items-column-list relative']//*[contains(text(),'%s')]")
    private WebElement draftLettersList;

    @FindBy(css = "span[class='max-w100 text-ellipsis']")
    private WebElement emailAddressInputFieldInDrafts;

    @FindBy(xpath = "//*[@data-testid='composer:send-button']")
    private WebElement sendEmailButton;

    @FindBy(xpath = "//span[contains(text(),'Sent')]")
    private WebElement sentButton;

    @FindBy(css = ".user-dropdown-displayName")
    private WebElement userDropDownMenu;

    @FindBy(xpath = "//button[normalize-space()='Sign out']")
    private WebElement signOutButton;

    public MailPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public boolean checkTheSuccessfulLogin() {
        return createNewMessageButton.isDisplayed();
    }

    public MailPage createNewEmailAndSaveItInTheDrafts(String email, String subject, String message) {
      createNewMessageButton.click();
        emailAddressInputField.sendKeys(email);
        subjectInputField.sendKeys(subject);
        driver.switchTo().frame(messageTextAreaIframe);
        messageTextArea.sendKeys(message);
        driver.switchTo().defaultContent();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOf(emergingSavedInformation));
        closePopUpNewMessageWindowButton.click();
        return this;
    }

    public MailPage openDrafts() {
        draftsButton.click();
        return this;
    }

    public boolean verifyThatMailInDraftsFolderBySubject(String subject) {
        return driver.findElement(By.xpath(String.format(subject, draftLettersList))).isDisplayed();
    }

    public MailPage openSavedLetterBySubject(String subject) {
        driver.findElement(By.xpath(String.format(subject, draftLettersList))).click();
        return this;
    }

    public boolean verifyEmailInSavedInDraftsLetterContent(String email) {
        return emailAddressInputFieldInDrafts.getText().contains(email);
    }

    public boolean verifyMessageInSavedInDraftsLetterContent(String message) {
        driver.switchTo().frame(messageTextAreaIframe);
        return messageTextArea.getText().contains(message);
    }

    public MailPage clickOnTheSendButtonOnEmailModalWindow() {
        sendEmailButton.click();
        return this;
    }

    public boolean verifyThatSendMailIsNotDisplayedInDrafts(String subject) {
        return driver.findElement(By.xpath(String.format(subject, draftLettersList))).isDisplayed();
    }

    public MailPage openSent() {
        sentButton.click();
        return this;
    }

    public boolean verifyThatSendMailIsDisplayedInSent(String subject) {
        return driver.findElement(By.xpath(String.format(subject, draftLettersList))).isDisplayed();
    }

    public void signOut() {
        userDropDownMenu.click();
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(signOutButton)).click();
    }
}
