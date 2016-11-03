///<reference path="../_app.d.ts"/>
var cf;
(function (cf) {
    var cplace;
    (function (cplace) {
        var workshop;
        (function (workshop) {
            'use strict';
            var DummyCtrl = (function () {
                function DummyCtrl($scope, $rootScope) {
                }
                return DummyCtrl;
            }());
            var DIRECTIVE = 'cfCplaceWorkshopDummy';
            function dummyDirective() {
                return {
                    restrict: 'A',
                    require: DIRECTIVE,
                    scope: true,
                    controller: DummyCtrl,
                    controllerAs: 'dummyCtrl',
                    // pre-link außen, pre-link innen, link innen, link außen
                    // <außen>
                    //      <innen></innen>
                    // <außen>
                    // 1. prelink außen
                    // 2. prelink innen
                    // 3. link innen
                    // 4. link außen
                    compile: function () {
                        return {
                            pre: function (scope, element, attrs, dummyCtrl) {
                                dummyCtrl.employees = JSON.parse(attrs.employees);
                                console.log(JSON.stringify(dummyCtrl.employees));
                            }
                        };
                    }
                };
            }
            angular.module("cf.cplace.workshop")
                .directive(DIRECTIVE, dummyDirective);
        })(workshop = cplace.workshop || (cplace.workshop = {}));
    })(cplace = cf.cplace || (cf.cplace = {}));
})(cf || (cf = {}));
