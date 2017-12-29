package tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import screens.*;
import utilities.*;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.Selenide.switchTo;
import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;

public class DV0002 {

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
    public void DV0002TEST(){
        detailViewer.enterMedewerker("94531294");
        detailViewer.clickZoekButton();
        detailViewer.checkOvereenkomstenDropdownLength(4);
        detailViewer.checkOvereenkomstenDropdown(1,"49916");
        detailViewer.checkOvereenkomstenDropdown(2,"49917");
        detailViewer.checkOvereenkomstenDropdown(3,"50006");
        detailViewer.checkOvereenkomstenDropdown(4,"50007");
        detailViewer.clickOvereenkomstDropdown("50007");
        detailViewer.clickZoekButton();
        detailViewer.checkHeaderEmployerId("11234570");
        detailViewer.checkHeaderEmployeeId("94531294");
        detailViewer.checkHeaderOvereenkomst("50007");
    }

    @AfterTest
    public void close(){
        closeWebDriver();
    }

}
