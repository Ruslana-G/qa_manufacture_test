package io.testomat;

import com.codeborne.selenide.Configuration;
import io.github.cdimascio.dotenv.Dotenv;
import io.testomat.common.Application;
import org.junit.jupiter.api.BeforeEach;

public class BaseTest {
    public static Dotenv env = Dotenv.load();
    protected static String username = env.get("USERNAME");
    protected static String password = env.get("PASSWORD");
    protected static String targetProjectName = "Manufacture light";

    Application app = new Application();


    @BeforeEach
    void openTestomatAndLogin() {
        app.signInPage.open();
        app.signInPage.loginUser(username, password);
    }

    static {
        Configuration.baseUrl = env.get("BASE_URL");
    }
}
