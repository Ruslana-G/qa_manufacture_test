package io.testomat;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import io.testomat.common.Application;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class ProjectPageTests extends BaseTest {
    Application app = new Application();

    @AfterEach
    void closeBrowser() {
        Selenide.closeWebDriver();
    }

    @Test
    public void findProjectTest() {

        app.projectsPage.searchForProject(targetProjectName);
        app.projectsPage.selectProject(targetProjectName);
        app.projectsPage.waitForProjectPageIsLoaded(targetProjectName);

    }

    @Test
    public void findTestsForProjectTest() {

        app.projectsPage.searchForProject(targetProjectName);
        app.projectsPage.projectTestsLabelByTitle(targetProjectName)
                .shouldBe(Condition.visible)
                .shouldHave(Condition.text("0 tests"));

        var targetProject = app.projectsPage.firstVisibleProjectCard();

        var actualAmountOfTests = app.projectsPage.testsCountFrom(targetProject);
        Assertions.assertEquals(0, actualAmountOfTests);

    }


}
