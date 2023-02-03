package pagebox;

import org.junit.jupiter.api.Tag;
import pagebox.components.CalendarComnponent;
import pagebox.components.RegistrationResultsModel;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;
@Tag("1")
public class RegistrationPage {

    private final static String TITLE_TEXT = "Student Registration Form";
    private CalendarComnponent calendarComnponent = new CalendarComnponent();
    private RegistrationResultsModel registrationResultsModel = new RegistrationResultsModel();

    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            dateOfBirthDateInput = $("#dateOfBirthInput");

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text(TITLE_TEXT));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setUserNumber(String value) {
        $("#userNumber").setValue(value);
        return this;
    }

    public RegistrationPage setEmail(String value) {
        $("#userEmail").setValue(value);

        return this;
    }

    public RegistrationPage setGender(String value) {
        $("#genterWrapper").$(byText(value)).click();
        return this;
    }

    public RegistrationPage setSubjectInput(String value) {
        $("#subjectsInput").setValue(value).pressEnter();
        return this;
    }

    public RegistrationPage setHobbies(String value) {
        $("#hobbiesWrapper").$(byText(value)).click();
        return this;
    }

    public RegistrationPage setUploadPicture(String value) {
        $("#uploadPicture").uploadFromClasspath(value);
        return this;
    }


    public RegistrationPage setAddress(String value) {
        $("#currentAddress").setValue(value);
        return this;
    }

    public RegistrationPage setStateCity(String value_state, String value_city) {
        $("#state").click();
        $("#stateCity-wrapper").$(byText(value_state)).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText(value_city)).click();
        $("#submit").click();
        return this;
    }


    public RegistrationPage setBirthDate(String year, String month, String day) {
        dateOfBirthDateInput.click();
        calendarComnponent.setDate(year, month, day);
        return this;
    }

    public RegistrationPage verifyResultModalAppear() {
        registrationResultsModel.verifyModalAppears();
        return this;
    }

    public RegistrationPage verifyResultModal(String key, String value) {
        registrationResultsModel.verifyResultModal(key, value);
        return this;
    }
}


