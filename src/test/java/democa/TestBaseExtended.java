package democa;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import pagebox.RegistrationPage;

import java.util.Map;


public class TestBaseExtended {

    RegistrationPage registrationPage = new RegistrationPage();


    @BeforeAll
    @Tag("chrome_99")
    static void beforeAll_chrome_99() {

        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browser = "chrome";
        Configuration.browserVersion = "100.0";
        Configuration.browserSize = System.getProperty("browserSize", "1920x1080");
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
        capabilities();
    }

    @BeforeAll
    @Tag("chrome_100")
    static void beforeAll_chrome_100() {

        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browser = "chrome";
        Configuration.browserVersion = "99.0";
        Configuration.browserSize = System.getProperty("browserSize", "1920x1080");
        Configuration.remote = System.getProperty("remote_url", "https://user1:1234@selenoid.autotests.cloud/wd/hub");
        capabilities();
    }

    @BeforeEach
    @Tag("firefox_97")
     void beforeAll_firefox_97() {

        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browser = "firefox";
        Configuration.browserVersion = "97.0";
        Configuration.browserSize = System.getProperty("browserSize", "1920x1080");
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
        capabilities();
    }

    @BeforeEach
    @Tag("firefox_98")
     void beforeAll_firefox_98() {

        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browser = "chrome";
        Configuration.browserVersion = "100.0";
        Configuration.browserSize = System.getProperty("browserSize", "1920x1080");
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
        capabilities();
    }

    @BeforeEach
    void AddListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }


    static void capabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;
    }
}
