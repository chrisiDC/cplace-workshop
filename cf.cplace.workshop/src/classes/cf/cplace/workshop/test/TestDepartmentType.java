/*
 * Copyright 2016, collaboration Factory AG. All rights reserved.
 */

package cf.cplace.workshop.test;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Nonnull;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;

import cf.cplace.platform.assets.file.Page;
import cf.cplace.platform.assets.file.PageSpace;
import cf.cplace.platform.test.page.PageTestHelper;
import cf.cplace.platform.test.util.StartServerRule;
import cf.cplace.workshop.WorkshopAppTypes;
import cf.cplace.workshop.WorkshopAppTypes.DEPARTMENT;
import cf.cplace.workshop.WorkshopPlugin;

public class TestDepartmentType {

    @Rule
    public TestRule startServer = new StartServerRule();

    private PageSpace space;

    @Before
    public void setup() {
        space = PageTestHelper.getNewPersistentSpace("Test Space");

        space = space.createWritableCopy();
        space.addApp(WorkshopPlugin.INSTANCE().app);
        space.persist();
    }

    @Test
    public void testParentHierarchy() {
        Page department_1 = createDepartment("bossdepartment", null);
        Page department_2 = createDepartment("developerdepartment", department_1);
        assertNotNull(department_2.get(DEPARTMENT.ROOT));
    }
    @Test
    public void testChildHierarchy() {
        Page department_1 = createDepartment("bossdepartment", null);
        Page department_2 = createDepartment("developerdepartment", department_1);
        Page department_3 = createDepartment("c#-developers", department_2);

        assertNotNull(department_3.get(DEPARTMENT.ROOT));
        assertEquals(department_1, department_3.get(DEPARTMENT.ROOT));

    }

    @Nonnull
    private Page createDepartment(String departmentName, Page parent) {
        Page result = Page.SCHEMA.createWritableEntity();
        result._space().set(space);
        result._customType().set(DEPARTMENT.TYPE.name);
        result.set(DEPARTMENT.DEPARTMENTID, departmentName);
        result.set(DEPARTMENT.PARENT, parent);
        result._name().setGeneratedName();
        result.persist();
        return result;
    }
}
