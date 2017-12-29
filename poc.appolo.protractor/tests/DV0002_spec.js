describe('DV0002', function() {
 	var apolloStart_page = require('../page/apolloStart_page.js');
 	var detailViewer_page = require('../page/detailViewer_page.js');

 	it('Go To detailviewer sreen', function() {
 		apolloStart_page.goToDetailviewer("Ga naar Detailviewer loonresultaten");
  	});

  	it('Enter medewerker nr en klik zoek knop', function() {
 		detailViewer_page.enterMedewerker("94531294");
 		detailViewer_page.clickZoekButton();
  	});

  	it('Controleer lengte dropdown = 4', function() {
 		detailViewer_page.checkOvereenkomstenDropdownLength(4);
  	});

  	it('Controleer of overeenkomsten correct worden weergegeven', function() {
 		detailViewer_page.checkOvereenkomstenDropdown(1,"49916");
 		detailViewer_page.checkOvereenkomstenDropdown(2,"49917");
 		detailViewer_page.checkOvereenkomstenDropdown(3,"50006");
 		detailViewer_page.checkOvereenkomstenDropdown(4,"50007");
  	});

  	it('Klik op een overeenkomst = 50007 en zoek knop', function() {
 		detailViewer_page.clickOvereenkomstenDropdown("50007");
 		detailViewer_page.clickZoekButton();
  	});

  	it('Controleer in de titelbalk dat de werkgever 11234570 vermeld is', function() {
 		detailViewer_page.checkHeaderEmployerId("11234570");
  	});

  	it('Controleer in de titelbalk dat de werkgever 94531294 vermeld is', function() {
 		detailViewer_page.checkHeaderEmployeeId("94531294");
  	});
  	
  	it('Controleer in de titelbalk dat de werkgever 50007 vermeld is', function() {
 		detailViewer_page.checkHeaderOvereenkomst("50007");
  	});

});