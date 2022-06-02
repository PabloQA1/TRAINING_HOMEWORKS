package AT.hw_5.page_objects;

import AT.hw_5.constants.IConstants;
import static com.codeborne.selenide.Selenide.open;

public abstract class BasePage implements IConstants {

    public void openPage(String url) {
      open(BASE_URL + url);
    }
}
