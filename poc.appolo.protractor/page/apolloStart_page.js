var apolloStart_page = function () {

	this.goToDetailviewer = function(page){
		//element(by.uiSref('base.wages')).click();
		element(by.xpath(".//a[. = '"+page+"']")).click();
	};

};
module.exports = new apolloStart_page();