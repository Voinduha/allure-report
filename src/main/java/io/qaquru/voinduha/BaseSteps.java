package io.qaquru.voinduha;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class BaseSteps {

    private static final String BASE_URL = "https://github.com";


    @Step("Открываем главную страницу")
    public void openMainPage() {
        open(BASE_URL);

    }

    @Step("Ищем репозиторий {repository}")
    public void searchForRepository(final String repository) {
        $(".header-search-input").click();
        $(".header-search-input").sendKeys(repository);
        $(".header-search-input").submit();
    }

    @Step("Переходим в репозиторий {repository}")
    public void goToRepositoryFromSearch(final String repository) {
        $(By.linkText(repository)).click();

    }

    @Step("Переходим в раздел Issues")
    public void openRepositoryIssues() {
        $(withText("Issues")).click();
    }


    @Step("Проверяем, что Issue с номером {Number} существует")
        public void shouldSeenIssueWithNumber(final String number)  {
        }
    }

