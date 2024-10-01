package tests;


import org.junit.jupiter.api.Test;
import pages.RegistrationPage;


public class PracticeFormPageObjectsTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();


    @Test
    void fillFormTest() {
        registrationPage.openPage()
                        .setFirstName("Mrs")
                        .setLastName("Smith")
                        .setEmail("test@test.xyz")
                        .setGender("Female")
                        .setUserNumber("9991112233")
                        .setDateOfBirth("01", "April", "2000")
                        .setSubjects("eng")
                        .setHobby("Reading")
                        .setPicture("1.png")
                        .setAddress("221B Baker Street")
                        .setState("Haryana")
                        .setCity("Panipat")
                        .pressSubmit();


        registrationPage.checkResult("Student Name", "Mrs Smith")
                        .checkResult("Student Email", "test@test.xyz")
                        .checkResult("Gender", "Female")
                        .checkResult("Mobile", "9991112233")
                        .checkResult("Date of Birth", "01 April,2000")
                        .checkResult("Subjects", "English")
                        .checkResult("Hobbies", "Reading")
                        .checkResult("Picture", "1.png")
                        .checkResult("Address", "221B Baker Street")
                        .checkResult("State and City", "Haryana Panipat");

    }


    @Test
    void minimumDataTest() {
        registrationPage.openPage()
                .setFirstName("Mrs")
                .setLastName("Smith")
                .setGender("Female")
                .setUserNumber("9991112233")
                .pressSubmit();

        registrationPage.checkResult("Student Name", "Mrs Smith")
                .checkResult("Gender", "Female")
                .checkResult("Mobile", "9991112233");
    }

}
