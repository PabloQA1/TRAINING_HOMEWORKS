package AT.hw_9.custom_utils;

import cucumber.api.junit.Cucumber;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.model.InitializationError;

import java.io.IOException;

public class CustomRunner extends Cucumber {
    public CustomRunner(Class clazz) throws InitializationError, IOException {
        super(clazz);
    }

    public void run(RunNotifier notifier){
        notifier.addListener(new PrettyCustomListener());
        super.run(notifier);
    }
}
