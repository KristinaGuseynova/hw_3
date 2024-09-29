package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920*1080";
        //Configuration.browser = "chrome";
        Configuration.pageLoadStrategy = "eager";
        Configuration.reopenBrowserOnFail = false;
    }
}
