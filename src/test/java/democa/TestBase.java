package democa;

import com.beust.jcommander.Parameters;
import org.junit.jupiter.api.Tag;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
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
        Configuration.browser = "opera";
        Configuration.holdBrowserOpen=true;


        DesiredCapabilities capabilities = new DesiredCapabilities();



    }
}
