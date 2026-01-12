package io.testomat;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import io.testomat.web.pages.ProjectsPage;
import io.testomat.web.pages.SignInPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class ProjectPageTests extends BaseTest {

    private static final ProjectsPage projectsPage = new ProjectsPage();
    private static final SignInPage signInPage = new SignInPage();
    static String username = env.get("USERNAME");
    static String password = env.get("PASSWORD");
    String targetProjectName = "Manufacture light";


    @BeforeEach
    void openTestomatAndLogin() {
        signInPage.open();
        signInPage.loginUser(username, password);
    }

    @AfterEach
    void closeBrowser() {
        Selenide.closeWebDriver();
    }

    @Test
    public void findProjectTest() {

        projectsPage.searchForProject(targetProjectName);
        projectsPage.selectProject(targetProjectName);
        projectsPage.waitForProjectPageIsLoaded(targetProjectName);

    }

    @Test
    public void findTestsForProjectTest() {

        projectsPage.searchForProject(targetProjectName);
        projectsPage.projectTestsLabelByTitle(targetProjectName)
                .shouldBe(Condition.visible)
                .shouldHave(Condition.text("0 tests"));

        var targetProject = projectsPage.firstVisibleProjectCard();

        var actualAmountOfTests = projectsPage.testsCountFrom(targetProject);
        Assertions.assertEquals(0, actualAmountOfTests);

    }


}
