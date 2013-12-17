package org.gwtbootstrap3.client.ui;

/*
 * #%L
 * GwtBootstrap3
 * %%
 * Copyright (C) 2013 GwtBootstrap3
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.ui.WidgetCollection;
import org.gwtbootstrap3.client.ui.constants.Styles;

/**
 * @author Joshua Godi
 */
public class Breadcrumbs extends OrderedList {
    private final WidgetCollection children = new WidgetCollection(this);

    public Breadcrumbs() {
        setStyleName(Styles.BREADCRUMB);
    }

    public Breadcrumbs(final Widget... widgets) {
        this();

        for (final Widget widget : widgets) {
            add(widget);
        }
    }

    @Override
    protected void onAttach() {
        if (!isOrWasAttached() && children.size() > 0) {
            final Widget lastWidget = children.get(children.size() - 1);
            lastWidget.addStyleName(Styles.ACTIVE);
        }

        super.onAttach();
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public void add(final Widget w) {
        w.addStyleName(Styles.ACTIVE);
        super.add(w);
        children.add(w);
    }
}
