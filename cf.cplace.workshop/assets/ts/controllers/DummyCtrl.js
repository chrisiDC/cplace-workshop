///<reference path="../_app.d.ts"/>
var cf;
(function (cf) {
    var cplace;
    (function (cplace) {
        var workshop;
        (function (workshop) {
            'use strict';
            var DummyCtrl = (function () {
                function DummyCtrl($scope) {
                }
                DummyCtrl.CTRL_NAME = MODULE_NAME + '.DummyCtrl';
                return DummyCtrl;
            }());
            angular.module(MODULE_NAME)
                .controller(DummyCtrl.CTRL_NAME, DummyCtrl);
        })(workshop = cplace.workshop || (cplace.workshop = {}));
    })(cplace = cf.cplace || (cf.cplace = {}));
})(cf || (cf = {}));
