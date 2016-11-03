///<reference path="../_app.d.ts"/>
module cf.cplace.workshop {
    'use strict';

    function dummyDirective():ng.IDirective {
        return {
            restrict: 'A',
            scope: true,
            link: (scope:ng.IScope, element:ng.IAugmentedJQuery, attrs) => {
                console.log('linking');
            }
        };
    }

    angular.module(MODULE_NAME)
        .directive('dummyDirective', dummyDirective);
}
