package screens;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selenide.$$;

public class ApolloStart {
    public void GoToPage(String page){
        $$(by("role", "button")).findBy(text(page)).shouldBe(visible).click();
    }
}
