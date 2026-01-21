package io.testomat.web.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;


public class ReadmePage {
    protected SelenideElement textarea = $("textarea");
    public static String targetReadmeText = "Hi There!";

    public ReadmePage clickOnEditReadme() {
        $(Selectors.byText("Edit Readme")).click();
        switchTo().frame($("#modal-overlays iframe[src='/ember-monaco/frame.html']"));
        return this;
    }

    public ReadmePage editFirstLineInEditor() {
        $(".view-lines div span").click();
        textarea.pressEnter();
        textarea.setValue(targetReadmeText);
        return this;
    }

    public ReadmePage clickOnUpdateButton() {
        switchTo().defaultContent();
        $(Selectors.withText("Update")).click();
        return this;
    }

    public ReadmePage clickOnCancelButton() {
        switchTo().defaultContent();
        $(Selectors.withText("Cancel")).click();
        return this;
    }

    public ReadmePage isLoaded() {
        $("span.setting-header").shouldHave(text("Readme"));
        return this;
    }

    public void checkErrorAlert() {
        $("div[data-alert].ember-notify-show").shouldBe(Condition.visible);
    }

}
