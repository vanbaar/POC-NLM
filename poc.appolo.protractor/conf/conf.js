// conf.js
exports.config = {
  framework: 'jasmine2',
  seleniumAddress: 'http://localhost:4444/wd/hub',
  specs: ['../tests/DV0002_spec.js'],
 multiCapabilities: [{
    browserName: 'internet explorer'
  },{
    browserName: 'chrome'
  },{
    browserName: 'firefox'
  }],

  /*
  jasmineNodeOpts: {
        onComplete: null, // onComplete will be called just before the driver quits.
        isVerbose: true,  // If true, display spec names.
        showColors: true, // If true, display spec names.
        includeStackTrace: true, // If true, include stack traces in failures.
        defaultTimeoutInterval: 30000, // Default time to wait in ms before a test fails.
        print: function () {
        }
    },
  */

  onPrepare: function () {
    console.log(__dirname+'\\..\\results');
    var algemeen = require('algemeen.js');
    var login_page = require('../page/login_page.js');
    var dashboard_page = require('../page/dashboard_page.js');

    algemeen.SpecReporter();
    algemeen.PrettyReporter();
    
    browser.manage().timeouts().pageLoadTimeout(20000);
    browser.manage().timeouts().implicitlyWait(20000);
    browser.waitForAngularEnabled(false);

    //login
    browser.get('https://t-clientaccess.acerta.be');
    browser.sleep(5000);
    login_page.correctLogin("ON900512","ON900512"); 
    //ga naar naar applicatie
    browser.sleep(5000);
    browser.waitForAngularEnabled(true);
    dashboard_page.goToApplication("Apollo Lonen"); 
  }
}