package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.Steps;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
@DisplayName("Assert that 'Issue' tab is visible")
public class IssueElementTest extends TestBase {
    @Test
    @DisplayName("Do test with simple listener")
    void issueElementTestWithListener() {

        SelenideLogger.addListener("allure", new AllureSelenide());

        open("");

        $(".search-input").click();
        $(".FormControl-input.QueryBuilder-Input.FormControl-medium")
                .setValue("JUAnnotation")
                .pressEnter();
        $$("[data-testid='results-list']").first().$("a").click();
        $("#issues-tab").shouldBe(Condition.visible);
    }

    @Test
    @DisplayName("Do test with lambda function")
    void issueElementTestWithLambda() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Opening page", () -> {
            open("");
        });

        step("Opening search field", () -> {
            $(".search-input").click();
        });
        step("Searching", () -> {
            $("input#query-builder-test")
                    .setValue("JUAnnotation")
                    .pressEnter();
        });
        step("Opening search result", () -> {
            $$("[data-testid='results-list']")
                    .first()
                    .$("a")
                    .click();
        });

        step("Asserting that Issues tab is visible", () -> {

            $("#issues-tab").shouldBe(Condition.visible);
        });

    }

    @Test
    @DisplayName("Do test with annotated steps")
    void issueElementTestWithSteps() {
        Steps steps = new Steps();
        steps.openPage()
                .openSearch()
                .searchRepository("JUAnnotation")
                .openingResult()
                .assertThatTabIsVisible();

    }
}
