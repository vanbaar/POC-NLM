package screens;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DetailViewer {

    //===============Navigate=============//

    public void clickZoekButton() {
        $(byId("search")).click();
    }
    public void clickLoonElementByYear(String Year) {
        clickLoonelement(Year);
    }
    public void clickLoonElementByPeriod(String Period) {
        clickLoonelement(Period);
    }
    public void enterMedewerker(String medewerkerNr) {
        $(byId("employee")).shouldBe(visible).setValue(medewerkerNr);
    }
    public void enterOvereenkomst(String overeenkomstNr) {
        $(byId("contractNumber_input")).setValue(overeenkomstNr);
    }
    public void clickOvereenkomstDropdown(String overeenkomst){
        $(byId("contractNumber_select")).click();
        $(byXpath(".//select[@id='contractNumber_select']/option[text() = '"+overeenkomst+"'] ")).click();
    }

    private static void clickLoonelement(String variable) {
        $$(by("type", "button")).findBy(text(variable)).click();
    }

    //===============Controleer=============//

    public void checkOvereenkomstenDropdownLength(int length){
        $$(byXpath(".//select[@id='contractNumber_select']/option[@label]")).shouldHaveSize(length);
    }
    public void checkOvereenkomstenDropdown(int position,String Overeenkomst){
        $(byXpath(".//select[@id='contractNumber_select']/option[@label]["+position+"]")).shouldHave(text(Overeenkomst));
        System.out.println($(byXpath(".//select[@id='contractNumber_select']/option[@label]["+position+"]")).shouldHave(text(Overeenkomst)));
    }
    public void checkHeaderEmployerId(String employerId){
        $(by("ng-show","wagesCtrl.wagePeriodsData.employerId")).shouldHave(text(employerId));
    }
    public void checkHeaderEmployeeId(String employeeId){
        $(by("ng-show","wagesCtrl.wagePeriodsData.employeeId")).shouldHave(text(employeeId));
    }
    public void checkHeaderOvereenkomst(String overeenkomst){
        $(by("ng-show","wagesCtrl.wagePeriodsData.contractNumber")).shouldHave(text(overeenkomst));
    }

}
