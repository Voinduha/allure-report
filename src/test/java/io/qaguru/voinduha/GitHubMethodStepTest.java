package io.qaguru.voinduha;

import io.qaquru.voinduha.BaseSteps;
import org.junit.jupiter.api.Test;

public class GitHubMethodStepTest {

    public BaseSteps steps = new BaseSteps();

    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final String ISSUE_NUMBER = "#68";

    @Test
    public void issueTestSearch() {

        steps.openMainPage();
        steps.searchForRepository(REPOSITORY);
        steps.goToRepositoryFromSearch(REPOSITORY);
        steps.openRepositoryIssues();
        steps.shouldSeenIssueWithNumber();


    }
}
