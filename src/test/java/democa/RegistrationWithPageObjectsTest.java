package democa;

import PageBox.RegistrationPage;

import org.junit.jupiter.api.Test;



public class RegistrationWithPageObjectsTest extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();


    @Test
    void succesfulRegistrationTest() {
        TestBase.beforeAll();

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
        String birthYear = "1999";
        String birthMonth = "December";
        String birthDay = "17";
        String pathPicture="img/1.png";



        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserNumber(userPhone)
                .setEmail(userEmail)
                .setGender(gender)
                .setBirthDate(birthYear, birthMonth, birthDay)
                .setSubjectInput(subject)
                .setHobbies(hobbies)
                .setUploadPicture(pathPicture)
                .setAddress(userAddress)
                .setStateCity(state,city);


        registrationPage.verifyResultModalAppear()
                .verifyResultModal("Student Name", firstName + " " + lastName)
                .verifyResultModal("Student Email", userEmail)
                .verifyResultModal("Gender", gender)
                .verifyResultModal("Mobile", userPhone)
                .verifyResultModal("Hobbies", hobbies)
                .verifyResultModal("Address", userAddress)
                .verifyResultModal("State and City", state + " " + city)
                .verifyResultModal("Subjects", subject);

    }
}



