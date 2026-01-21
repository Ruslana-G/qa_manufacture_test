package io.testomat.common;

import io.testomat.web.pages.ProjectPage;
import io.testomat.web.pages.ProjectsPage;
import io.testomat.web.pages.ReadmePage;
import io.testomat.web.pages.SignInPage;

public class Application {
    public final ProjectsPage projectsPage = new ProjectsPage();
    public final ProjectPage projectPage = new ProjectPage();
    public final SignInPage signInPage = new SignInPage();
    public final ReadmePage readmePage = new ReadmePage();
}
