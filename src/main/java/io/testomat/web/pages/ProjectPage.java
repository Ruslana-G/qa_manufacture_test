package io.testomat.web.pages;

import com.codeborne.selenide.Selectors;

import static com.codeborne.selenide.Selenide.$;

public class ProjectPage {
    public ProjectPage openBurgerMenu() {
        $(".ember-basic-dropdown-trigger svg.md-icon-dots-horizontal").click();
        return this;
    }

    public ProjectPage openReadme() {
        $(".ember-basic-dropdown-trigger[aria-expanded='true']")
                .closest(".ember-basic-dropdown")
                .$("a[href$='/readme']")
                .click();
        return this;
    }

    public ProjectPage editReadme() {
        $(Selectors.byLinkText("Edit")).click();
        return this;
    }
}
