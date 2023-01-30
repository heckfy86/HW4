package democa;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Tag;
import pagebox.components.CalendarComnponent;
import pagebox.components.RegistrationResultsModel;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

@Tag("1")
public class RegistrationPageExterned {

    private final static String TITLE_TEXT = "Student Registration Form";
    private CalendarComnponent calendarComnponent = new CalendarComnponent();
    private RegistrationResultsModel registrationResultsModel = new RegistrationResultsModel();

    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            dateOfBirthDateInput = $("#dateOfBirthInput");

    public RegistrationPageExterned openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text(TITLE_TEXT));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public RegistrationPageExterned setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationPageExterned setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationPageExterned setUserNumber(String value) {
        $("#userNumber").setValue(value);
        return this;
    }

    public RegistrationPageExterned setEmail(String value) {
        $("#userEmail").setValue(value);

        return this;
    }

    public RegistrationPageExterned setGender(String value) {
        $("#genterWrapper").$(byText(value)).click();
        return this;
    }

    public RegistrationPageExterned setSubjectInput(String value) {
        $("#subjectsInput").setValue(value).pressEnter();
        return this;
    }

    public RegistrationPageExterned setHobbies(String value) {
        $("#hobbiesWrapper").$(byText(value)).click();
        return this;
    }

    public RegistrationPageExterned setUploadPicture(String value) {
        $("#uploadPicture").uploadFromClasspath(value);
        return this;
    }
    public RegistrationPageExterned setAddress(String value) {
        $("#currentAddress").setValue(value);
        return this;
    }

    public RegistrationPageExterned setStateCity(String value_state, String value_city) {
        $("#state").click();
        $("#stateCity-wrapper").$(byText(value_state)).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText(value_city)).click();
        $("#submit").click();
        return this;
    }


    public RegistrationPageExterned setBirthDate(String year, String month, String day) {
        dateOfBirthDateInput.click();
        calendarComnponent.setDate(year, month, day);
        return this;
    }

    public RegistrationPageExterned verifyResultModalAppear() {
        registrationResultsModel.verifyModalAppears();
        return this;
    }

    public RegistrationPageExterned verifyResultModal(String key, String value) {
        registrationResultsModel.verifyResultModal(key, value);
        return this;
    }
}


