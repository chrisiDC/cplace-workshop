/*
 * Copyright 2015, collaboration Factory AG. All rights reserved.
 */
package cf.cplace.workshop;

import cf.cplace.platform.handler.TestSetupHandlerExtension;
import cf.cplace.platform.services.CombinedAndCompressedPluginJavaScriptExtension;
import cf.cplace.platform.services.MustBeActivated;
import cf.cplace.platform.services.Plugin;
import cf.cplace.platform.services.SingleAngularModuleExtension;
import cf.cplace.workshop.handler.SetupHandler;
import cf.cplace.workshop.script.WorkshopWidgetDefinition;

public final class WorkshopPlugin extends Plugin implements MustBeActivated {

    private static WorkshopPlugin instance = new WorkshopPlugin();

    public final TestSetupHandlerExtension testSetupHandlerExtension = new TestSetupHandlerExtension(SetupHandler.class);

    public static WorkshopPlugin INSTANCE() {
        return instance;
    }

    private WorkshopPlugin() {
    }

    public final WorkshopApp app = new WorkshopApp();

    public final CombinedAndCompressedPluginJavaScriptExtension javaScriptIncludes = new CombinedAndCompressedPluginJavaScriptExtension();

    public final SingleAngularModuleExtension angularModulesExtension = new SingleAngularModuleExtension();

    public final WorkshopWidgetDefinition workshopWidgetDefinition = new WorkshopWidgetDefinition();

    @Override
    public String getDefaultLanguage() {
        return "de";
    }
}
