package pages;

import com.codeborne.selenide.*;

import io.qameta.allure.Step;
import static com.codeborne.selenide.Selenide.*;

public class Steps {

    @Step("Opening page")
    public Steps openPage() {
        open("");
        return this;
    }

    @Step("Opening search field")
    public Steps openSearch() {
        $(".search-input").click();
        return this;
    }

    @Step("Searching")
    public Steps searchRepository(String repoName) {
        $("input#query-builder-test")
                .setValue(repoName)
                .pressEnter();
        return this;
    }

    @Step("Opening search result")
    public Steps openingResult() {
        $$("[data-testid='results-list']")
                .first()
                .$("a")
                .click();
        return this;
    }

    @Step("Asserting that Issues tab is visible")
    public Steps assertThatTabIsVisible() {
        $("#issues-tab").shouldBe(Condition.visible);
        return this;
    }

}
