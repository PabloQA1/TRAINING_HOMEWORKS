package AT.hw_9.custom_utils;

import AT.hw_9.utils.ScreenShotSaver;
import lombok.extern.log4j.Log4j2;
import org.junit.runner.Description;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;

@Log4j2
public class PrettyCustomListener extends RunListener {

   protected ScreenShotSaver screenShotSaver = new ScreenShotSaver();

    public PrettyCustomListener() {
        super();
    }

    @Override
    public void testStarted(Description description) {
        log.info("****************************Test started:" + description.getDisplayName() + "****************************");
    }

    @Override
    public void testFinished(Description description) {
        log.info("****************************Test finished:" + description.getDisplayName() + "****************************");
        screenShotSaver.saveScreenShot("");
    }

    @Override
    public void testFailure(Failure failure) {
        log.error("****************************Test failed:" + failure.getMessage() + "****************************");
        screenShotSaver.saveScreenShot("");
    }

    @Override
    public void testIgnored(Description description) {
        log.info("****************************Test failed:" + description.getDisplayName() + "****************************");
    }
}
