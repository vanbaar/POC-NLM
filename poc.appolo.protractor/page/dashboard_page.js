var dashboard_page = function () {

	this.goToApplication = function(applicatie){
		element(by.xpath(".//h4[contains(@class, 'application__title') and text() = '"+applicatie+"']/parent::a")).getAttribute("href").then(function(link){
			browser.get(link);
		});
	};

};
module.exports = new dashboard_page();