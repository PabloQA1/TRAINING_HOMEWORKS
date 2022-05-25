package AT.hw_6;

import AT.hw_3.utils.PropertyReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MailPageTest extends BasePageTest {

    @Test
    public void saveNewCreatedEmailInDraftsTest() {
        loginPage
                .openLoginPage()
                .logIn(System.getenv().getOrDefault("accountName", PropertyReader.getProperty("accountName")),
                        System.getenv().getOrDefault("password", PropertyReader.getProperty("password")))
                .createNewEmailAndSaveItInTheDrafts(
                        "john.smith.test.acc@mail.ru",
                        "This is test email message!",
                        "HELLO!")
                .openDrafts();
        Assert.assertTrue(mailPage.verifyThatMailInDraftsFolderBySubject("This is test email message!"));
    }

    @Test
    public void verifyTheDraftContentOfSavedLatterInTheDraftsTest() {
        loginPage
                .openLoginPage()
                .logIn(System.getenv().getOrDefault("accountName", PropertyReader.getProperty("accountName")),
                        System.getenv().getOrDefault("password", PropertyReader.getProperty("password")))
                .createNewEmailAndSaveItInTheDrafts(
                        "john.smith.test.acc@mail.ru",
                        "This is test email message!",
                        "HELLO!")
                .openDrafts()
                .openSavedLetterBySubject("This is test email message!");
        Assert.assertTrue(mailPage.verifyEmailInSavedInDraftsLetterContent("john.smith.test.acc@mail.ru"));
        Assert.assertTrue(mailPage.verifyMessageInSavedInDraftsLetterContent("HELLO!"));
    }

    @Test
    public void checkThePossibilityOfSendingLetterTest() {
        loginPage
                .openLoginPage()
                .logIn(System.getenv().getOrDefault("accountName", PropertyReader.getProperty("accountName")),
                        System.getenv().getOrDefault("password", PropertyReader.getProperty("password")))
                .createNewEmailAndSaveItInTheDrafts(
                        "john.smith.test.acc@mail.ru",
                        "This is test email message!",
                        "HELLO!")
                .openDrafts()
                .openSavedLetterBySubject("This is test email message!")
                .clickOnTheSendButtonOnEmailModalWindow();
        Assert.assertTrue(mailPage.verifyThatSendMailIsNotDisplayedInDrafts("This is test email message!"));
        mailPage.openSent();
        Assert.assertTrue(mailPage.verifyThatSendMailIsDisplayedInSent("This is test email message!"));
    }
}