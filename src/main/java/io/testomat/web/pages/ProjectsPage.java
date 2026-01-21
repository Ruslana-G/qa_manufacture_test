package io.testomat.web.pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.testomat.utils.StringParsers.parseIntegerFromString;

public class ProjectsPage {

    public ProjectsPage searchForProject(String targetProjectName) {
        $("#container #search").setValue(targetProjectName);
        return this;
    }

    public void selectProject(String targetProjectName) {
        $(String.format("a[title='%s'] h3", targetProjectName)).click();
    }

    public void waitForProjectPageIsLoaded(String targetProjectName) {
        $$("a")
                .findBy(text(targetProjectName.trim()))
                .shouldBe(Condition.visible);
    }

    public SelenideElement projectTestsLabelByTitle(String projectName) {
        return $(String.format("a[title='%s'] p", projectName));
    }

    public SelenideElement firstVisibleProjectCard() {
        return $$("#grid ul li")
                .filter(Condition.visible)
                .shouldBe(CollectionCondition.sizeGreaterThan(0))
                .first();
    }

    public Integer testsCountFrom(SelenideElement projectCard) {
        return parseIntegerFromString(projectCard.$("p").getText());
    }


}
