package io.testomat;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static io.testomat.utils.StringParsers.parseIntegerFromString;

public class ProjectPageTests extends BaseTest {

    String url = env.get("BASE_URL");
    String username = env.get("USERNAME");
    String password = env.get("PASSWORD");
    String targetProjectName = "Manufacture light";

    @BeforeEach
    void openTestomatAndLogin() {
        open(url);
        loginUser(username, password);
    }

    @AfterEach
    void closeBrowser() {
        Selenide.closeWebDriver();
    }

    @Test
    public void findProjectTest() {

        searchForProject(targetProjectName);
        selectProject(targetProjectName);
        waitForProjectPageIsLoaded(targetProjectName);

    }

    @Test
    public void findTestsForProjectTest() {

        searchForProject(targetProjectName);
        projectTestsLabelByTitle(targetProjectName)
                .shouldBe(Condition.visible)
                .shouldHave(Condition.text("0 tests"));

        var targetProject = firstVisibleProjectCard();

        var actualAmountOfTests = testsCountFrom(targetProject);
        Assertions.assertEquals(0, actualAmountOfTests);

    }


    private SelenideElement projectTestsLabelByTitle(String projectName) {
        return $(String.format("a[title='%s'] p", projectName));
    }

    private SelenideElement firstVisibleProjectCard() {
        return $$("#grid ul li")
                .filter(Condition.visible)
                .shouldBe(CollectionCondition.sizeGreaterThan(0))
                .first();
    }

    private Integer testsCountFrom(SelenideElement projectCard) {
        return parseIntegerFromString(projectCard.$("p").getText());
    }

    private static void loginUser(String email, String password) {
        $("#content-desktop #user_email").setValue(email);
        $("#content-desktop #user_password").setValue(password);
        $("#content-desktop #user_remember_me").click();
        $("#content-desktop input[name='commit']").click();
    }

    private void searchForProject(String targetProjectName) {
        $("#container #search").setValue(targetProjectName);

    }

    private void selectProject(String targetProjectName) {
        $(String.format("a[title='%s'] h3", targetProjectName)).click();
    }

    private void waitForProjectPageIsLoaded(String targetProjectName) {
        $$("a")
                .findBy(text(targetProjectName.trim()))
                .shouldBe(Condition.visible);
    }
}
