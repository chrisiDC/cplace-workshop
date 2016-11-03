/*
 * Copyright 2015, collaboration Factory AG. All rights reserved.
 */
package cf.cplace.workshop.test;

import cf.cplace.platform.services.Plugin;
import cf.cplace.platform.test.AbstractTestTemplateSubstitutions;
import cf.cplace.workshop.WorkshopPlugin;

public class TestTemplateSubstitutions extends AbstractTestTemplateSubstitutions {

    @Override
    protected Plugin getTestPlugin() {
        return WorkshopPlugin.INSTANCE();
    }

}
