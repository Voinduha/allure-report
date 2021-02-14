package io.qaguru.voinduha;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.parameter;
import static io.qameta.allure.Allure.step;

public class GitHubIssueTestWithSteps {

    private static final String BASE_URL = "https://github.com";

    private static final String ISSUES = "Issues";

    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final String ISSUE_NUMBER = "#68";

    @Test
    @Owner("Daniel Vulikh")
    @Severity(SeverityLevel.NORMAL)
    @Feature("Issues")
    @Story("Ищем issues в существующем репозитории")
    @Link(name = "Base URL", value = BASE_URL)
    @DisplayName("Поиск issue по номеру репозитория")

    public void testIssueSearch() {
        // Подключаем к тесту логгер
        SelenideLogger.addListener("allure", new AllureSelenide());

        parameter("Repository", REPOSITORY);
        parameter("Issue Number", ISSUE_NUMBER);

        step("Открываем главную страницу ", () -> {
            open(BASE_URL);
        });
        step("Ищем репозиторий " + REPOSITORY, () -> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(REPOSITORY);
            $(".header-search-input").submit();
        });
        step("Переходим в репозиторий " + REPOSITORY, () -> {
            $(By.linkText(REPOSITORY)).click();
        });
        step("Переходим в раздел " + ISSUES, () -> {
            $(withText("Issue")).click();
        });
        step("Проверяем, что Issue с номером " + ISSUE_NUMBER + " существует", () -> {
            $(withText(ISSUE_NUMBER)).should(Condition.exist);
        });
    }
}
