package screens;

import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byValue;
import static com.codeborne.selenide.Selenide.$;

public class Login {

    public void CorrectLogin(String username,String password) {
        $(byId("username")).setValue(username);
        $(byId("password")).setValue(password);
        $(byValue("Aanmelden")).click();
    }

}
