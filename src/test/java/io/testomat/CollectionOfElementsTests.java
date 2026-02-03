package io.testomat;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$$;

public class CollectionOfElementsTests extends BaseTest {
    private final ElementsCollection labelCountOfTests =
            $$("ul li");

    @Test
    @DisplayName("Find all product experiments")
    public void findAllProductExperiments() {
        labelCountOfTests.shouldHave(CollectionCondition.sizeGreaterThan(0));

        for (SelenideElement labelCountOfTest : labelCountOfTests) {
            labelCountOfTest.shouldHave(Condition.text("3 tests")
                    .or(Condition.text("2 tests").or(Condition.text("1 tests")).or(Condition.text("0 tests"))));

            labelCountOfTests.filter(Condition.text("0 tests")).shouldHave(CollectionCondition.sizeGreaterThan(0));
        }

    }

    @Test
    @DisplayName("Each experiment has at least one test")
    public void eachExperimentHasAtLeastOneTest() {
        labelCountOfTests.shouldHave(CollectionCondition.sizeGreaterThan(0));

        labelCountOfTests.forEach(label ->
                label.shouldNotHave(Condition.text("0 tests"))
        );
    }

}
