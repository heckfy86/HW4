package democa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationTest {

    @BeforeAll
    static void beforeAll ()
    {

        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
  //      Configuration.holdBrowserOpen=true;
    }

    @Test
    void succesfulRegistrationTest () {

            open("/automation-practice-form");
            $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
            executeJavaScript("$('#fixedban').remove()");
            executeJavaScript("$('footer').remove()");


        $("#firstName").setValue("Ruslan");
        $("#lastName").setValue("Ivanov");
        $("#userEmail").setValue("gmail08@ya.ru");
        $("#genterWrapper").$(byText("Male")).click(); // best
        $("#userNumber").setValue("89376431608");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("December");
        $(".react-datepicker__year-select").selectOption("1999");
        $(".react-datepicker__day--017").click();
        $("#subjectsInput").setValue("Math").pressEnter();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#uploadPicture").uploadFromClasspath("img/1.png");
        $("#currentAddress").setValue("443031 st Gagarina 15-10");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("Haryana")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Karnal")).click();
        $("#submit").click();
    }
}
