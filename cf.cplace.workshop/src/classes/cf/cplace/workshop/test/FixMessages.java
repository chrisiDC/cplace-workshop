/*
 * Copyright 2015, collaboration Factory AG. All rights reserved.
 */
package cf.cplace.workshop.test;

import cf.cplace.platform.test.i18n.MessagesUtility;
import cf.cplace.workshop.WorkshopPlugin;

public class FixMessages {

    public static void main(String[] args) {
        MessagesUtility.fix(WorkshopPlugin.INSTANCE());
    }
}
