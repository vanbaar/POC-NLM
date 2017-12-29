var detailViewer_page = function () {

	this.clickZoekButton = function(){
		element(by.id("search")).click();
	};

	this.enterMedewerker = function(medewerkerNr){
		var medewerkerNrTerm = medewerkerNr;
		for(i = 0; i < medewerkerNrTerm.length; i++){
			element(by.id('employee')).sendKeys(medewerkerNrTerm.charAt(i));
		}
	};

	this.checkOvereenkomstenDropdownLength = function(aantal){
		var list = element.all(by.css("#contractNumber_select option"));
		expect(list.count()).toBe(aantal + 1);
	};

	this.checkOvereenkomstenDropdown = function(position, overeenkomst){
		var contract = element(by.xpath(".//select[@id='contractNumber_select']/option[@label]["+position+"]"));
		expect(contract.getText()).toEqual(overeenkomst);
        //$(byXpath(".//select[@id='contractNumber_select']/option[text() = '"+overeenkomst+"'] ")).click();
	};

	this.clickOvereenkomstenDropdown = function(overeenkomst){
		element(by.id("contractNumber_select")).click();
        element(by.xpath(".//select[@id='contractNumber_select']/option[text() = '"+overeenkomst+"'] ")).click();
	};

	this.checkHeaderEmployerId = function(employerId){
		var el = element(by.css("[ng-show*='wagesCtrl.wagePeriodsData.employerId']"));
		expect(el.getText()).toContain(employerId);
	};

	this.checkHeaderEmployeeId = function(employeeId){
		var el = element(by.css("[ng-show*='wagesCtrl.wagePeriodsData.employeeId']"));
		expect(el.getText()).toContain(employeeId);
	};

	this.checkHeaderOvereenkomst = function(overeenkomst){
		var el = element(by.css("[ng-show*='wagesCtrl.wagePeriodsData.contractNumber']"));
		expect(el.getText()).toContain(overeenkomst);
	};


};
module.exports = new detailViewer_page();