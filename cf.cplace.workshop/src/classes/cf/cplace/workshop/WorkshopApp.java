/*
 * Copyright 2015, collaboration Factory AG. All rights reserved.
 */
package cf.cplace.workshop;

import java.util.List;

import javax.annotation.Nonnull;

import cf.cplace.platform.assets.custom.CustomAttributeChangeEventListener;
import cf.cplace.platform.assets.custom.CustomAttributeChangeListener;
import cf.cplace.platform.assets.custom.CustomEntity;
import cf.cplace.platform.assets.custom.CustomValue;
import cf.cplace.platform.assets.file.Page;
import cf.cplace.platform.internationalization.Message;
import cf.cplace.platform.orm.DoOnWritableCopyFun;
import cf.cplace.platform.orm.PersistentEntity;
import cf.cplace.platform.services.CustomAttributeChangeEventListenersExtension;
import cf.cplace.platform.services.app.ProgrammaticallyDefinedAppWithTypeDefs;
import cf.cplace.workshop.WorkshopAppTypes.DEPARTMENT;

public class WorkshopApp extends ProgrammaticallyDefinedAppWithTypeDefs {

    public static final Message displayName = new Message() {
    };

    public static final Message description = new Message() {
    };

    final CustomAttributeChangeEventListenersExtension listenersExtension = new CustomAttributeChangeEventListenersExtension() {
        @Override
        public void addListeners(List<CustomAttributeChangeEventListener> listeners) {
            listeners.add(new CustomAttributeChangeListener(DEPARTMENT.PARENT, CustomAttributeChangeEventListener.TriggerStage.AFTER_PERSIST) {
                @Override
                public void trigger(CustomEntity entity, List<CustomValue> oldValues) {
                    if (DEPARTMENT.TYPE.isTypeOf(entity)) {
                        Page page = (Page) entity;
                        PersistentEntity.doOnWritableCopy(page, new DoOnWritableCopyFun<Page>() {
                            @Override
                            public void fun(@Nonnull Page input) {

                                Page parent = getRoot(input);
                                input.set(DEPARTMENT.ROOT, parent);
                            }

                            @Nonnull
                            private Page getRoot(@Nonnull Page parent) {
                                Page current;

                                do {
                                    current = parent.get(DEPARTMENT.PARENT);
                                    if (current != null) parent = current;
                                }
                                while (current != null);
                                return parent;
                            }
                        });
                    }

                }
            });
        }
    };

    WorkshopApp() {
        // package scope, only the plugin creates an instance
    }

    @Nonnull
    @Override
    public Message getDisplayName() {
        return displayName;
    }

    @Override
    public Message getDescription() {
        return description;
    }

    @Override
    public String getIconName() {
        return "fa-info";
    }

    @Override
    protected Class[] getTypeDefContainerClasses() {
        return new Class[]{ WorkshopAppTypes.class };
    }

}
