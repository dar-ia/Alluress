package pages;

import com.codeborne.selenide.*;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static com.codeborne.selenide.Selenide.*;

public class Steps {

    @Step("Opening page")
    public Steps openPage() {
        open("");
        attachScreenshot();
        return this;
    }

    @Step("Opening search field")
    public Steps openSearch() {
        $(".search-input").click();
        attachScreenshot();
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
        sleep(10000);
        attachScreenshot();
        $$("[data-testid='results-list']")
                .first()
                .$("a")
                .click();

        return this;
    }

    @Step("Asserting that Issues tab is visible")
    public Steps assertThatTabIsVisible() {
        attachScreenshot();
        $("#issues-tab").shouldBe(Condition.visible);
        return this;
    }

    @Attachment(value = "Screen", type = "image/png", fileExtension = "png")
    public byte[] attachScreenshot() {
        return ((TakesScreenshot)WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }

}
