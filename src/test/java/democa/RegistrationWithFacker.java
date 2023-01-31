package democa;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import pagebox.RegistrationPage;

import org.junit.jupiter.api.Test;

@Tag("facker")
public class RegistrationWithFacker extends TestBaseExtended {

    RegistrationPageExterned registrationPage = new RegistrationPageExterned();
    @Test
    void succesfulRegistrationTest() {

        Faker faker = new Faker();

        String firstName = faker.name().firstName();

        String lastName = faker.name().lastName();
        String userEmail = faker.internet().emailAddress();
        String gender = faker.options().option("Male", "Female", "Other");
        String userPhone = String.valueOf(faker.number().numberBetween(9370000000L, 9379999999L));
        String subject = faker.options().option("Civics", "Biology", "Social Studies", "Maths", "English");
        String hobbies = faker.options().option("Reading", "Sports", "Music");
        String userAddress = faker.address().fullAddress();
        String state = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
        String city = null;

        if (state.equals("NCR")) {
            city = faker.options().option("Delhi", "Gurgaon", "Noida");
        } else if (state.equals("Uttar Pradesh")) {
            city = faker.options().option("Agra", "Lucknow", "Merrut");
        } else if (state.equals("Haryana")) {
            city = faker.options().option("Karnal", "Panipat");
        } else if (state.equals("Rajasthan")) {
            city = faker.options().option("Jaipur", "Jaiselmer");
        }


        String birthYear = String.valueOf(faker.number().numberBetween(1900, 2022));
        String birthMonth = faker.options().option("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");
        String birthDay = String.format("%02d", faker.number().numberBetween(1, 28));
        //  String pathPicture = "img/1.png";


        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserNumber(userPhone)
                .setEmail(userEmail)
                .setGender(gender)
                .setBirthDate(birthYear, birthMonth, birthDay)
                .setSubjectInput(subject)
                .setHobbies(hobbies)
                //.setUploadPicture(pathPicture)
                .setAddress(userAddress)
                .setStateCity(state, city)
        ;


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



