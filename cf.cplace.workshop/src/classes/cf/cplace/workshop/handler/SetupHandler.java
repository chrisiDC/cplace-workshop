/*
 * Copyright 2016, collaboration Factory AG. All rights reserved.
 */

package cf.cplace.workshop.handler;

import cf.cplace.platform.PlatformAppTypes;
import cf.cplace.platform.PlatformAppTypes.DEFAULT_PAGE_TYPE;
import cf.cplace.platform.assets.WidgetContainer;
import cf.cplace.platform.assets.custom.WidgetConfiguration;
import cf.cplace.platform.assets.file.Page;
import cf.cplace.platform.assets.file.PageSpace;
import cf.cplace.platform.assets.layout.Layout;
import cf.cplace.platform.assets.search.Filters;
import cf.cplace.platform.assets.search.Search;
import cf.cplace.platform.client.SessionLocal;
import cf.cplace.platform.handler.AbstractTestSetupHandler;
import cf.cplace.platform.handler.Forwarder;
import cf.cplace.platform.handler.Line;
import cf.cplace.platform.handler.Station;
import cf.cplace.platform.internationalization.Message;
import cf.cplace.platform.script.WidgetTypes;
import cf.cplace.platform.script.widgets.EmbeddedSearchAsTableWidgetDefinition;
import cf.cplace.platform.test.TestHelper;
import cf.cplace.platform.test.page.PageTestHelper;
import cf.cplace.workshop.WorkshopAppTypes;
import cf.cplace.workshop.WorkshopAppTypes.DEPARTMENT;
import cf.cplace.workshop.WorkshopAppTypes.EMPLOYEE;
import cf.cplace.workshop.WorkshopPlugin;
import cf.cplace.workshop.WorkshopWidgetTypes;
import cf.cplace.workshop.script.WorkshopWidgetDefinition;

public class SetupHandler extends AbstractTestSetupHandler {



    Page rootPage;
    Page createSomeDepartmentPage;
    Page workShopWidgetPage;


    protected final Station GOTO_HOME = new Line() {
        @Override
        public void next(Forwarder f) {
            f.go(rootPage);
        }

    };

    @Override
    protected Station doDoBusinessLogic() {

        SessionLocal.getSession().setUserWithoutUpdatingLoginDate(TestHelper.getMustermannNoCheckAccess());
        PageSpace rootSpace = PageTestHelper.getRootSpace();
        rootSpace = rootSpace.createWritableCopy();
        rootSpace._apps().add(WorkshopPlugin.INSTANCE().app);
        rootSpace.persist();

        rootPage = rootSpace.getRootPageWithoutReadAccessCheck();

        Page department_1 = Page.SCHEMA.createWritableEntity();
        department_1._space().set(rootSpace);
        department_1._customType().set(DEPARTMENT.TYPE.name);
        department_1.set(DEPARTMENT.DEPARTMENTID,"devDepartment");
        department_1._name().setGeneratedName();
        department_1.persist();

        createSomeDepartmentPage = createSomeDepartmentPage(rootSpace, rootPage);
        workShopWidgetPage = createWorkshopWidgetPage(rootSpace, rootPage);

        return GOTO_HOME;
    }

    static Page createSomeDepartmentPage(PageSpace space, Page rootPage) {
        Page result = Page.SCHEMA.createWritableEntity();

        result._name().set("Alle Mitarbeiter");
        result._space().set(space);
        result.set(DEFAULT_PAGE_TYPE.ICON_NAME, "fa-user");
        result.set(DEFAULT_PAGE_TYPE.PARENT, rootPage);

        WidgetContainer wco = result.adapt(WidgetContainer.class);
        Layout layout = wco.getLayout();
        layout.rows.clear();
        wco.reorder(layout);

        Search search = new Search();
        search.add(Filters.type(EMPLOYEE.TYPE));
        search.add(Filters.embeddingSpace());
        String searchAsJson = search.serializeAsJson();

        WidgetConfiguration employeesTableWidgetConfiguration = WidgetConfiguration.createWidgetConfigurationWithRandomId(EmbeddedSearchAsTableWidgetDefinition.KIND);
        employeesTableWidgetConfiguration.set(WidgetTypes.EMBEDDED_SEARCH_AS_TABLE.SEARCH, searchAsJson);
        employeesTableWidgetConfiguration.set(WidgetTypes.EMBEDDED_SEARCH_AS_TABLE.TITLE, EMPLOYEE.name_plural.get());
        wco.addWidget(employeesTableWidgetConfiguration, 0, 0);

        result.persist();
        return result;
    }

    static Page createWorkshopWidgetPage(PageSpace space, Page rootPage) {
        Page result = Page.SCHEMA.createWritableEntity();

        result._name().set("THe Workshop widget");
        result._space().set(space);
        result.set(DEFAULT_PAGE_TYPE.ICON_NAME, "fa-user");
        result.set(DEFAULT_PAGE_TYPE.PARENT, rootPage);

        WidgetContainer wco = result.adapt(WidgetContainer.class);
        Layout layout = wco.getLayout();
        layout.rows.clear();
        wco.reorder(layout);

        WidgetConfiguration widgetConfig = WidgetConfiguration.createWidgetConfigurationWithRandomId(WorkshopWidgetDefinition.KIND);
        widgetConfig.set(WorkshopWidgetTypes.EMPLOYEE.EMPLOYEEID, "abc");
        wco.addWidget(widgetConfig, 0, 0);

        result.persist();
        return result;
    }


}
