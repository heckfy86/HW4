package democa;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationTest {

    @BeforeAll
    static void beforeAll() {

        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        //Configuration.holdBrowserOpen = true;
    }

    @Test
    void succesfulRegistrationTest() {

        String firstName = "Ruslan";
        String lastName = "Ivanov";
        String userEmail = "gmail08@ya.ru";
        String gender = "Male";
        String userPhone = "9376431608";
        String subject = "Math";
        String hobbies = "Reading";
        String userAddress = "443031 st Gagarina 15-10";
        String state = "Haryana";
        String city = "Karnal";

            open("/automation-practice-form");
            $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
            executeJavaScript("$('#fixedban').remove()");
            executeJavaScript("$('footer').remove()");


            $("#firstName").setValue(firstName);
            $("#lastName").setValue(lastName);
            $("#userEmail").setValue(userEmail);
            $("#genterWrapper").$(byText(gender)).click();
            $("#userNumber").setValue(userPhone);

            $("#subjectsInput").setValue(subject).pressEnter();
            $("#hobbiesWrapper").$(byText(hobbies)).click();
            $("#uploadPicture").uploadFromClasspath("img/1.png");
            $("#currentAddress").setValue(userAddress);
            $("#state").click();
            $("#stateCity-wrapper").$(byText("Haryana")).click();
            $("#city").click();
            $("#stateCity-wrapper").$(byText("Karnal")).click();
            $("#submit").click();

            $$(".table-responsive tr").findBy(text("Student Name" + " " + firstName + " " + lastName)).shouldBe(visible);
            $$(".table-responsive tr").findBy(text("Student Email" + " " + userEmail)).shouldBe(visible);
            $$(".table-responsive tr").findBy(text("Gender" + " " + gender)).shouldBe(visible);
            $$(".table-responsive tr").findBy(text("Mobile" + " " + userPhone)).shouldBe(visible);
            $$(".table-responsive tr").findBy(text("Hobbies" + " " + hobbies)).shouldBe(visible);
            $$(".table-responsive tr").findBy(text("Address" + " " + userAddress)).shouldBe(visible);
            $$(".table-responsive tr").findBy(text("State and City" + " " + state + " " + city)).shouldBe(visible);
            $$(".table-responsive tr").findBy(text("Subjects" + " " + subject)).shouldBe(visible);
        }

    }


