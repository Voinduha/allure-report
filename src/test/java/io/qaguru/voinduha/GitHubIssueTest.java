package io.qaguru.voinduha;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class GitHubIssueTest {

    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final String ISSUE_NUMBER = "#68";

    @Test

    public void testIssueSearch() {

        // Подключаем к тесту логгер
        SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://github.com");

        $(".header-search-input").setValue(REPOSITORY).pressEnter();
        $(By.linkText(REPOSITORY)).click();
        $(withText("Issues")).click();
        $(withText(ISSUE_NUMBER)).shouldBe(Condition.visible);
    }
}


