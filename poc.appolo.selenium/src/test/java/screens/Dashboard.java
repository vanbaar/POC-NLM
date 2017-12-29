package screens;

import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.switchTo;

public class Dashboard {
    public void GoToApplication(String applicatie){
        String link = $(byXpath(".//h4[contains(@class, 'application__title') and text() = '"+applicatie+"']/parent::a")).getAttribute("href");
        open(link);
    }
}
