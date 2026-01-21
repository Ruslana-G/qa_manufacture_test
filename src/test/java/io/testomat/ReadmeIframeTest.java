package io.testomat;

import io.testomat.common.Application;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ReadmeIframeTest extends BaseTest {
    Application app = new Application();

    @Test
    @DisplayName("Update readme text in iframe")
    public void updateReadmeTextInIframe() {
        app.projectsPage.searchForProject(targetProjectName)
                .selectProject(targetProjectName);

        app.projectPage.openBurgerMenu().openReadme().editReadme();
        app.readmePage.isLoaded()
                .clickOnEditReadme()
                .editFirstLineInEditor()
                .clickOnUpdateButton()
                .checkErrorAlert();

    }

    @Test
    @DisplayName("Cancel readme text updating in iframe")
    public void cancelReadmeTextUpdatingInIframe() {
        app.projectsPage.searchForProject(targetProjectName)
                .selectProject(targetProjectName);

        app.projectPage.openBurgerMenu().openReadme().editReadme();
        app.readmePage.isLoaded()
                .clickOnEditReadme()
                .editFirstLineInEditor()
                .clickOnCancelButton()
                .isLoaded();

    }
}
