package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class PracticeFormTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920*1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        $("#firstName").setValue("Mr");
        $("#lastName").setValue("Smith");
        $("#userEmail").setValue("test@test.xyz");
        $(byText("Female")).click();
        $("#userNumber").setValue("79991112233");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").$(byText("March")).click();
        $(".react-datepicker__year-select").$(byText("2020")).click();
        $("div.react-datepicker__day.react-datepicker__day--010").click();
        $("#subjectsInput").setValue("eng").pressEnter();
        $(byText("Reading")).scrollTo().click();
        $("#uploadPicture").uploadFromClasspath("1.png");
        $("#currentAddress").setValue("221B Baker Street");
        $("#state").click();
        $("#react-select-3-option-2").click();
        $("#city").click();
        $("#react-select-4-option-1").click();
        $("#submit").click();


        $(".table-responsive").shouldHave(text("Mr Smith"));
        $(".table-responsive").shouldHave(text("test@test.xyz"));
        $(".table-responsive").shouldHave(text("Female"));
        $(".table-responsive").shouldHave(text("10 March,2020"));
        $(".table-responsive").shouldHave(text("English"));
        $(".table-responsive").shouldHave(text("Reading"));
        $(".table-responsive").shouldHave(text("1.png"));
        $(".table-responsive").shouldHave(text("221B Baker Street"));
        $(".table-responsive").shouldHave(text("Haryana Panipat"));

    }

}
