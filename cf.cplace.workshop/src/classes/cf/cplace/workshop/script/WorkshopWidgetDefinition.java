package cf.cplace.workshop.script;

import javax.annotation.Nonnull;

import org.json.JSONObject;

import cf.cplace.platform.assets.custom.WidgetConfiguration;
import cf.cplace.platform.assets.custom.def.TypeDef;
import cf.cplace.platform.internationalization.Message;
import cf.cplace.platform.script.WidgetTypes;
import cf.cplace.platform.services.App;
import cf.cplace.platform.template.Escaping;
import cf.cplace.platform.template.PrintSubstitution;
import cf.cplace.platform.template.Template;
import cf.cplace.platform.widget.WidgetDefinition;
import cf.cplace.platform.widget.WidgetSubstitutionParameters;
import cf.cplace.platform.widget.WidgetTemplateSubstitution;
import cf.cplace.workshop.WorkshopPlugin;
import cf.cplace.workshop.WorkshopWidgetTypes;

public class WorkshopWidgetDefinition extends WidgetDefinition {

    public static final String KIND = "cf.cplace.workshop.widget";

    public static final Message widgetName = new Message() {
    };

    @Override
    public String getWidgetKind() {
        return KIND;
    }

    @Override
    public TypeDef getConfigurationType() {
        return WorkshopWidgetTypes.EMPLOYEE.TYPE;
    }

    @Override
    public Message getName() {
        return widgetName;
    }

    public WidgetTemplateSubstitution getContentSubstitution(WidgetConfiguration conf, WidgetSubstitutionParameters params) {
        return new WidgetTemplateSubstitution() {
            @Override
            public void putSubstitutions(Template template) {
                template.put("data", new PrintSubstitution(Escaping.htmlAttribute) {
                    @Override
                    protected String print() {
                        return new JSONObject().toString();
                    }
                });
            }
        };
    }

    @Nonnull
    @Override
    public App getApp() {
        return WorkshopPlugin.INSTANCE().app;
    }
}
