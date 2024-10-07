package tests;


import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import utils.RandomUtils;


public class PracticeFormPageObjectsTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    RandomUtils randomUtils = new RandomUtils();

    String firstName = randomUtils.firstName(),
     lastName = randomUtils.lastName(),
     userEmail = randomUtils.userEmail(),
     userGender = randomUtils.userGender(),
     userPhoneNumber = randomUtils.userPhoneNumber(),
     dayOfBirth = randomUtils.dayOfBirth(),
     monthOfBirth = randomUtils.monthOfBirth(),
     yearOfBirth = randomUtils.yearOfBirth(),
     userSubject = randomUtils.userSubject(),
     userHobby = randomUtils.userHobby(),
     userAddress = randomUtils.userAddress(),
     userState = randomUtils.userState(),
     userCity = randomUtils.userCity(userState);



    @Test
    void fillFormTest() {

        registrationPage.openPage()
                        .setFirstName(firstName)
                        .setLastName(lastName)
                        .setEmail(userEmail)
                        .setGender(userGender)
                        .setUserNumber(userPhoneNumber)
                        .setDateOfBirth(dayOfBirth, monthOfBirth, yearOfBirth)
                        .setSubjects(userSubject)
                        .setHobby(userHobby)
                        .setPicture("1.png")
                        .setAddress(userAddress)
                        .setState(userState)
                        .setCity(userCity)
                        .pressSubmit();


        registrationPage.checkResult("Student Name", firstName + " " + lastName)
                        .checkResult("Student Email", userEmail)
                        .checkResult("Gender", userGender)
                        .checkResult("Mobile", userPhoneNumber)
                        .checkResult("Date of Birth", dayOfBirth + " " + monthOfBirth +"," + yearOfBirth)
                        .checkResult("Subjects", userSubject)
                        .checkResult("Hobbies", userHobby)
                        .checkResult("Picture", "1.png")
                        .checkResult("Address", userAddress)
                        .checkResult("State and City", userState + " " + userCity);

    }


    @Test
    void minimumDataTest() {
        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender(userGender)
                .setUserNumber(userPhoneNumber)
                .pressSubmit();

        registrationPage.checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Gender", userGender)
                .checkResult("Mobile", userPhoneNumber);
    }


    @Test
    void NegativeTest() {
        registrationPage.openPage()
                .pressSubmit();

        registrationPage.checkNoResult();
    }


}
