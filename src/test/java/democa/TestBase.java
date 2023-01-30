package democa;

import org.junit.jupiter.api.Tag;
import pagebox.RegistrationPage;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

@Tag("1")
public class TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @BeforeAll
    static void beforeAll() {

        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
       // Configuration.holdBrowserOpen=true;
    }
}
