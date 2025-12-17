
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class ProjectPageTests {

    @Test
    public void findProjectTest(){
        open("https://app.testomat.io/");

        $("#content-desktop #user_email").setValue("ruslana.glushchenko@gmail.com");
        $("#content-desktop #user_password").setValue("Uc92SE@LVPsfazC");
        $("#content-desktop #user_remember_me").click();
        $("#content-desktop input[name='commit']").click();
        $("#container #search").setValue("Manufacture light");
        $("a[title='Manufacture light'] h3").click();
        sleep(5000);

        $("a[title='Manufacture light']").shouldBe(visible);
    }
}
