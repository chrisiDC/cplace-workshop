/*
 * Copyright 2015, collaboration Factory AG. All rights reserved.
 */
package cf.cplace.workshop;

import cf.cplace.platform.assets.custom.FixedAppTypes;
import cf.cplace.platform.assets.custom.Multiplicities;
import cf.cplace.platform.assets.custom.def.AttributeDef;
import cf.cplace.platform.assets.custom.def.MultiPageReferenceAttributeDef;
import cf.cplace.platform.assets.custom.def.SingleStringAttributeDef;
import cf.cplace.platform.assets.custom.def.TypeDef;
import cf.cplace.platform.assets.custom.typeConstraints.factory.TypeConstraintFactories;
import cf.cplace.platform.assets.layout.Column;
import cf.cplace.platform.assets.layout.Layout;
import cf.cplace.platform.assets.layout.Row;
import cf.cplace.platform.internationalization.Message;
import cf.cplace.platform.widget.WidgetContainerDef;
import cf.cplace.platform.widget.WidgetHelper;

/**
 * Custom types used to configure this plugin's widget definitions.
 */
public class WorkshopWidgetTypes {

    public static class WIDGETCONFIG {



        public static final Message employeeId_name = new Message() {
        };

        public static final SingleStringAttributeDef EMPLOYEEID =
                AttributeDef.build("cf.cplace.workshop.employeeId", employeeId_name,
                        TypeConstraintFactories.stringConstraint(Multiplicities.exactlyOne));

        public static final TypeDef TYPE = new TypeDef("Employee", EMPLOYEEID);
    }
}
