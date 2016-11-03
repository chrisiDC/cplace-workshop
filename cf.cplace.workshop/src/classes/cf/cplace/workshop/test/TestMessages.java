/*
 * Copyright 2015, collaboration Factory AG. All rights reserved.
 */
package cf.cplace.workshop.test;

import cf.cplace.platform.services.Plugin;
import cf.cplace.platform.test.i18n.AbstractTestMessages;
import cf.cplace.workshop.WorkshopPlugin;

public class TestMessages extends AbstractTestMessages {

    @Override
    protected Plugin getTestPlugin() {
        return WorkshopPlugin.INSTANCE();
    }

}
