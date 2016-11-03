package cf.cplace.workshop;

import java.util.List;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

import cf.cplace.platform.assets.WidgetWithContent;
import cf.cplace.platform.assets.custom.CustomSerializable;
import cf.cplace.platform.assets.custom.FixedAppTypes.Fixed;
import cf.cplace.platform.assets.custom.FixedAppTypes;
import cf.cplace.platform.assets.custom.Multiplicities;
import cf.cplace.platform.assets.custom.NumberValue;
import cf.cplace.platform.assets.custom.RichStringValue;
import cf.cplace.platform.assets.custom.BooleanValue;
import cf.cplace.platform.assets.custom.StringValue;
import cf.cplace.platform.assets.custom.RichStringValue;
import cf.cplace.platform.assets.custom.def.*;
import cf.cplace.platform.assets.custom.typeConstraints.factory.TypeConstraintFactories;
import cf.cplace.platform.assets.layout.Column;
import cf.cplace.platform.assets.layout.Layout;
import cf.cplace.platform.assets.layout.Row;
import cf.cplace.platform.internationalization.Message;
import cf.cplace.platform.internationalization.UserLanguage;
import cf.cplace.platform.util.Utilities;
import cf.cplace.platform.widget.WidgetContainerDef;
import cf.cplace.platform.widget.WidgetHelper;
import cf.cplace.platform.assets.custom.DatePickerFormatDomain;

public class WorkshopAppTypes {


    @FixedAppTypes.Fixed(orderIndex = 500)
    public static class EMPLOYEE {

        public static final Message department_name = new Message() {
        };

        public static final MultiPageReferenceAttributeDef DEPARTMENT =
                AttributeDef.build("cf.cplace.workshop.department", department_name,
                        TypeConstraintFactories.linkPageConstraint(Multiplicities.atLeastOne, "cf.cplace.workshop.department", null, true)).withShowInNewDialog()
                        .withAllowedDuplicates();


        public static final Message employeeId_name = new Message() {
        };

        public static final SingleStringAttributeDef EMPLOYEEID =
                AttributeDef.build("cf.cplace.workshop.employeeId", employeeId_name,
                        TypeConstraintFactories.stringConstraint(Multiplicities.exactlyOne));


        public static final Message employeeName_name = new Message() {
        };
        public static final Message employeeName_shortName = new Message() {
        };

        public static final SingleStringAttributeDef EMPLOYEENAME =
                AttributeDef.build("cf.cplace.workshop.employeeName", employeeName_name,
                        TypeConstraintFactories.stringConstraint(Multiplicities.exactlyOne))
                        .withLocalizedShortName(employeeName_shortName);


        private static final WidgetContainerDef WIDGET_CONTAINER_DEF = WidgetContainerDef.createFromLayoutWithWidgetsWithContent(
                Layout.fromRows(
                        Row.fromColumns(
                                new Column(12, WidgetHelper.WIKI)),
                        Row.fromColumns(
                                new Column(6, WidgetHelper.ATTRIBUTES),
                                new Column(6, WidgetHelper.INCOMING_REFERENCES))));

        public static final Message name_singular = new Message() {
        };
        public static final Message name_plural = new Message() {
        };
        public static final TypeDef TYPE = new TypeDef("Employee", name_singular, name_plural, " ",
                WIDGET_CONTAINER_DEF
                , EMPLOYEEID, EMPLOYEENAME, DEPARTMENT)
                .withNotFixedNameGenerationPattern("<cf.cplace.workshop.employeeId>");
    }

    @FixedAppTypes.Fixed(orderIndex = 400)
    public static class DEPARTMENT {

        public static final Message departmentId_name = new Message() {
        };

        public static final SingleStringAttributeDef DEPARTMENTID =
                AttributeDef.build("cf.cplace.workshop.departmentId", departmentId_name,
                        TypeConstraintFactories.stringConstraint(Multiplicities.exactlyOne));


        public static final Message parent_name = new Message() {
        };

        public static final Message root = new Message() {
        };

        public static final SinglePageReferenceAttributeDef PARENT =
                AttributeDef.build("cf.cplace.workshop.parent", parent_name,
                        TypeConstraintFactories.linkPageConstraint(Multiplicities.maximalOne, "cf.cplace.workshop.department", null, true)).withShowInNewDialog();

        public static final SinglePageReferenceAttributeDef ROOT =
                AttributeDef.build("cf.cplace.workshop.root", root,
                        TypeConstraintFactories.linkPageConstraint(Multiplicities.maximalOne, "cf.cplace.workshop.department", null, true)).withReadOnly();


        private static final WidgetContainerDef WIDGET_CONTAINER_DEF = WidgetContainerDef.createFromLayoutWithWidgetsWithContent(
                Layout.fromRows(
                        Row.fromColumns(
                                new Column(12, WidgetHelper.WIKI)),
                        Row.fromColumns(
                                new Column(6, WidgetHelper.ATTRIBUTES),
                                new Column(6, WidgetHelper.INCOMING_REFERENCES))));

        public static final Message name_singular = new Message() {
        };
        public static final Message name_plural = new Message() {
        };
        public static final TypeDef TYPE = new TypeDef("cf.cplace.workshop.department", name_singular, name_plural, "fa-id-badge",
                WIDGET_CONTAINER_DEF
                , DEPARTMENTID, PARENT)
                .withNotFixedNameGenerationPattern("<cf.cplace.workshop.departmentId>");
    }


}