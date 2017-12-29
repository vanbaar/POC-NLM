## protractor-custom-locators
This module adds a custom locators to a protractor instance that finds elements by their attribute using [addLocator](http://www.protractortest.org/#/api?view=ProtractorBy.prototype.addLocator) method.
### list of currently available locators:
* locator that finds element by `data-test-id` attribute
  * locator name - `dataTestId`
* locator that finds element by `data-reactid` attribute
  * locator name - `dataReactId`
## Installation
`$ npm install protractor-custom-locators`
## Usage
that you should put in your protractor.config.js:
```
import AddCustomLocators from "protractor-custom-locators/index";

onPrepare() {
   AddCustomLocators.addDataTestId(protractor);
   AddCustomLocators.addDataReactId(protractor);
}
```
The locator can then be used with `element(by.locatorName(args))`.
