package AT.hw_9.utils;

import AT.hw_9.browser.Browser;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenShotSaver {

    protected WebDriver driver = Browser.getWebDriverInstance();

    public void saveScreenShot(String fileN) {
        if (driver != null) {
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy-h-mm-ss-SS--a");
            String formattedDate = sdf.format(date);
            String fileName = (fileN.isEmpty() ? "screenshot-" : fileN) + formattedDate;
            try {
                FileUtils.copyFile(scrFile, new File(String.format("./%s.png", fileName)));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
