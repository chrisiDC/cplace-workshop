///<reference path="../_app.d.ts"/>
var cf;
(function (cf) {
    var cplace;
    (function (cplace) {
        var workshop;
        (function (workshop) {
            'use strict';
            function dummyDirective() {
                return {
                    restrict: 'A',
                    scope: true,
                    link: function (scope, element, attrs) {
                        console.log('linking');
                    }
                };
            }
            angular.module(MODULE_NAME)
                .directive('dummyDirective', dummyDirective);
        })(workshop = cplace.workshop || (cplace.workshop = {}));
    })(cplace = cf.cplace || (cf.cplace = {}));
})(cf || (cf = {}));
