package democa;

import org.junit.jupiter.api.Tag;
import org.openqa.selenium.remote.DesiredCapabilities;
import pagebox.RegistrationPage;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;


public class TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @BeforeAll
        static void beforeAll() {

        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.browser = "opera";
        Configuration.holdBrowserOpen=true;


        DesiredCapabilities capabilities = new DesiredCapabilities();



    }
}
