package tests;

import org.junit.jupiter.api.Test;

public class SimpleJUnitTest {


    @Test
    void firstTest() {
        System.out.println("###    firstTest()");
    }

    @Test
    void secondTest() {
        System.out.println("###    secondTest()");
    }

    @Test
    void thirdTest() {
        System.out.println("###    thirdTest()");
    }


    /*successfulSearchTest() {
        open("https://www.google.com/");
        $("[name=q]").setValue("selenide").pressEnter();
        $("[id=search]").shouldHave(text("https://selenide.org"));
    } */
}

