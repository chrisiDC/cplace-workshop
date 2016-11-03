///<reference path="../_app.d.ts"/>
module cf.cplace.workshop {
    'use strict';

    class DummyCtrl {
        static CTRL_NAME = MODULE_NAME + '.DummyCtrl';

        constructor($scope:ng.IScope) {
        }
    }

    angular.module(MODULE_NAME)
        .controller(DummyCtrl.CTRL_NAME, DummyCtrl);
}
