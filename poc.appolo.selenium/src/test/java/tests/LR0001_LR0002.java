package tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import screens.ApolloStart;
import screens.Dashboard;
import screens.DetailViewer;
import screens.Login;
import utilities.Algemeen;
import utilities.PropertiesLoader;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;

public class LR0001_LR0002 {
    Algemeen algemeen = new Algemeen();
    PropertiesLoader prop = new PropertiesLoader();
    Login login = new Login();
    Dashboard dashBoard = new Dashboard();
    ApolloStart apolloStart = new ApolloStart();
    DetailViewer detailViewer = new DetailViewer();

    @BeforeTest
    @Parameters("browser")
    public void setup(String browser) throws Exception {
        algemeen.setup(browser);
        open(prop.get("url_login"));
        login.CorrectLogin(prop.get("username"),prop.get("password"));
        dashBoard.GoToApplication("Apollo Lonen");
        apolloStart.GoToPage("Ga naar DetailViewer Loonresultaten");
    }

    @Test
    public void LR0001_LR0002TEST(){
        detailViewer.enterOvereenkomst("49868");
        detailViewer.clickZoekButton();
        //<--Stap3
        detailViewer.clickLoonElementByYear("2017");
        detailViewer.clickLoonElementByPeriod("30/11/2017");
        //<--stap6, stap7,...etc
    }

    @AfterTest
    public void close(){
        closeWebDriver();
    }
}
