package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import static com.codeborne.selenide.Selenide.*;

public class TestBase {
    @BeforeAll
    static void commonConfig() {
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = "https://github.com/";
        //Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1280×1024";
    }


    @AfterEach
    void afterEachConfig() {
        closeWebDriver();
    }
}