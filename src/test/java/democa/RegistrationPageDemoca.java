package democa;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Tag;
import pagebox.components.CalendarComnponent;
import pagebox.components.RegistrationResultsModel;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

@Tag("1")
public class RegistrationPageDemoca {

    private final static String TITLE_TEXT = "Student Registration Form";
    private CalendarComnponent calendarComnponent = new CalendarComnponent();
    private RegistrationResultsModel registrationResultsModel = new RegistrationResultsModel();

    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            dateOfBirthDateInput = $("#dateOfBirthInput");

    public RegistrationPageDemoca openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text(TITLE_TEXT));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public RegistrationPageDemoca setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationPageDemoca setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationPageDemoca setUserNumber(String value) {
        $("#userNumber").setValue(value);
        return this;
    }

    public RegistrationPageDemoca setEmail(String value) {
        $("#userEmail").setValue(value);

        return this;
    }

    public RegistrationPageDemoca setGender(String value) {
        $("#genterWrapper").$(byText(value)).click();
        return this;
    }

    public RegistrationPageDemoca setSubjectInput(String value) {
        $("#subjectsInput").setValue(value).pressEnter();
        return this;
    }

    public RegistrationPageDemoca setHobbies(String value) {
        $("#hobbiesWrapper").$(byText(value)).click();
        return this;
    }

    public RegistrationPageDemoca setUploadPicture(String value) {
        $("#uploadPicture").uploadFromClasspath(value);
        return this;
    }
    public RegistrationPageDemoca setAddress(String value) {
        $("#currentAddress").setValue(value);
        return this;
    }

    public RegistrationPageDemoca setStateCity(String value_state, String value_city) {
        $("#state").click();
        $("#stateCity-wrapper").$(byText(value_state)).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText(value_city)).click();
        $("#submit").click();
        return this;
    }


    public RegistrationPageDemoca setBirthDate(String year, String month, String day) {
        dateOfBirthDateInput.click();
        calendarComnponent.setDate(year, month, day);
        return this;
    }

    public RegistrationPageDemoca verifyResultModalAppear() {
        registrationResultsModel.verifyModalAppears();
        return this;
    }

    public RegistrationPageDemoca verifyResultModal(String key, String value) {
        registrationResultsModel.verifyResultModal(key, value);
        return this;
    }
}


