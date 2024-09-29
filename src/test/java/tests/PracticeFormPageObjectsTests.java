package tests;


import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class PracticeFormPageObjectsTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();


    @Test
    void fillFormTest() {
        registrationPage.openPage()
                        .setFirstName("Mr")
                        .setLastName("Smith")
                        .setEmail("test@test.xyz")
                        .setGender("Female")
                        .setUserNumber("79991112233")
                        .setDateOfBirth("01", "April", "2000");


        $("#subjectsInput").setValue("eng").pressEnter();
        $(byText("Reading")).scrollTo().click();
        $("#uploadPicture").uploadFromClasspath("1.png");
        $("#currentAddress").setValue("221B Baker Street");
        $("#state").click();
        $("#react-select-3-option-2").click();
        $("#city").click();
        $("#react-select-4-option-1").click();
        $("#submit").click();


        registrationPage.checkResult("Student Name", "Mr Smith")
                        .checkResult("Student Email", "test@test.xyz");
        $(".table-responsive").shouldHave(text("Female"));
        $(".table-responsive").shouldHave(text("10 March,2020"));
        $(".table-responsive").shouldHave(text("English"));
        $(".table-responsive").shouldHave(text("Reading"));
        $(".table-responsive").shouldHave(text("1.png"));
        $(".table-responsive").shouldHave(text("221B Baker Street"));
        $(".table-responsive").shouldHave(text("Haryana Panipat"));

    }

}
