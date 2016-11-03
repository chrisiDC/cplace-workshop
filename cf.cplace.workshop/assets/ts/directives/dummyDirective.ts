///<reference path="../_app.d.ts"/>
module cf.cplace.workshop {
    'use strict';


    class DummyCtrl {
        employees:Array<Employee>;

        constructor($scope:ng.IScope, $rootScope:ng.IRootScopeService) {

        }
    }

    const DIRECTIVE = 'cfCplaceWorkshopDummy';

    function dummyDirective():ng.IDirective {
        return {
            restrict: 'A',
            require: DIRECTIVE,
            scope: true, // scope: true => child-scope, scope: {} => isolated-scope (NUR FÜR TEMPLATE)
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

            compile: () => {
                return {
                    pre: (scope:ng.IScope, element:ng.IAugmentedJQuery, attrs:any, dummyCtrl:DummyCtrl) => {
                        dummyCtrl.employees = JSON.parse(attrs.employees);
                        console.log(JSON.stringify(dummyCtrl.employees));
                    }
                }
            }
        };
    }

    angular.module("cf.cplace.workshop")
        .directive(DIRECTIVE, dummyDirective);
}
