import {Ptor} from "protractor";

export default class AddCustomLocators {

    static addDataTestId(protractor: Ptor) {
     protractor.by.addLocator('dataTestId',
         function (expected, parentElement: HTMLElement | null) {
            let using = parentElement || document;
            let nodes = using.querySelectorAll('[data-test-id]');
        return Array.prototype.filter.call(nodes, function (node) {
            return (node.getAttribute('data-test-id') === expected);
        });
     });
 };

    static addDataReactId(protractor: Ptor) {
        protractor.by.addLocator('dataReactId',
            function (expected, parentElement: HTMLElement | null) {
                let using = parentElement || document;
                let nodes = using.querySelectorAll('[data-reactid]');
                return Array.prototype.filter.call(nodes, function (node) {
                    return (node.getAttribute('data-reactid') === expected);
                });
            });
    };

}