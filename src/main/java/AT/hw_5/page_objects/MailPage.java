package AT.hw_5.page_objects;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.disappear;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;

public class MailPage extends BasePage {

    private final SelenideElement createNewMessageButton = $(By.xpath("//*[@data-testid='sidebar:compose']"));
    private final SelenideElement emailAddressInputField = $(By.xpath("//*[@data-testid='composer:to']"));
    private final SelenideElement subjectInputField = $(By.xpath("//*[@data-testid='composer:subject']"));
    private final SelenideElement messageTextAreaIframe = $(By.xpath("//iframe[@title='Email composer']"));
    private final SelenideElement messageTextArea = $(By.xpath("//*[@id='rooster-editor']"));
    private final SelenideElement draftsButton = $(By.xpath("//span[contains(text(),'Drafts')]"));
    private final SelenideElement emergingSavedInformation = $(By.xpath("//span[contains(text(),'Saved')]"));
    private final SelenideElement closePopUpNewMessageWindowButton = $(By.xpath("//*[@data-testid='composer:close-button']"));
    private final SelenideElement draftLettersList = $(By.xpath("//*[@class='relative items-column-list relative']//*[contains(text(),'%s')]"));
    private final SelenideElement emailAddressInputFieldInDrafts = $(By.cssSelector("span[class='max-w100 text-ellipsis']"));
    private final SelenideElement sendEmailButton = $(By.xpath("//*[@data-testid='composer:send-button']"));
    private final SelenideElement sentButton = $(By.xpath("//span[contains(text(),'Sent')]"));
    private final SelenideElement userDropDownMenu = $(By.cssSelector(".user-dropdown-displayName"));
    private final SelenideElement signOutButton = $(By.xpath("//button[normalize-space()='Sign out']"));

    public boolean checkTheSuccessfulLogin() {
        return createNewMessageButton.shouldBe(visible).isDisplayed();
    }

    public MailPage createNewEmailAndSaveItInTheDrafts(String email, String subject, String message) {
        createNewMessageButton.click();
        emailAddressInputField.sendKeys(email);
        subjectInputField.sendKeys(subject);
        switchTo().frame(messageTextAreaIframe);
        messageTextArea.sendKeys(message);
        switchTo().defaultContent();
        emergingSavedInformation.shouldBe(disappear);
        closePopUpNewMessageWindowButton.click();
        return this;
    }

    public MailPage openDrafts() {
        draftsButton.click();
        return this;
    }

    public boolean verifyThatMailInDraftsFolderBySubject(String subject) {
        return $(By.xpath(String.format(subject, draftLettersList))).isDisplayed();
    }

    public MailPage openSavedLetterBySubject(String subject) {
        $(By.xpath(String.format(subject, draftLettersList))).click();
        return this;
    }

    public boolean verifyEmailInSavedInDraftsLetterContent(String email) {
        return emailAddressInputFieldInDrafts.getText().contains(email);
    }

    public boolean verifyMessageInSavedInDraftsLetterContent(String message) {
        switchTo().frame(messageTextAreaIframe);
        return messageTextArea.getText().contains(message);
    }

    public MailPage clickOnTheSendButtonOnEmailModalWindow() {
        sendEmailButton.click();
        return this;
    }

    public boolean verifyThatSendMailIsNotDisplayedInDrafts(String subject) {
        return $(By.xpath(String.format(subject, draftLettersList))).isDisplayed();
    }

    public MailPage openSent() {
        sentButton.click();
        return this;
    }

    public boolean verifyThatSendMailIsDisplayedInSent(String subject) {
        return $(By.xpath(String.format(subject, draftLettersList))).isDisplayed();
    }

    public void signOut() {
        userDropDownMenu.shouldBe(disappear).click();
        signOutButton.shouldBe(disappear).click();
    }
}
