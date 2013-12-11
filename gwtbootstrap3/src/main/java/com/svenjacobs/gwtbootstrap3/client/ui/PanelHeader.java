package com.svenjacobs.gwtbootstrap3.client.ui;

/*
 * #%L
 * GwtBootstrap3
 * %%
 * Copyright (C) 2013 Sven Jacobs
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
import com.svenjacobs.gwtbootstrap3.client.ui.base.mixin.IdMixin;
import com.svenjacobs.gwtbootstrap3.client.ui.constants.Styles;

/**
 * @author Joshua Godi
 */
public class PanelHeader extends Div implements HasId {
    private final IdMixin<PanelHeader> idMixin = new IdMixin<PanelHeader>(this);

    public PanelHeader() {
        setStyleName(Styles.PANEL_HEADING);
    }

    @Override
    public void add(final Widget child) {
        if (!(child instanceof Heading)) {
            throw new IllegalArgumentException("PanelHeader can only have children that are of type Heading");
        }
        child.setStyleName(Styles.PANEL_TITLE);

        // If we are adding a child, then we don't need the inner text of the div
        setText("");

        super.add(child);
    }

    public void setText(final String text) {
        // Only want text to be available if the widget count is 0!
        // This is a safety net for if people use setText and add a Heading!
        if (getWidgetCount() == 0) {
            getElement().setInnerText(text);
        }
    }

    @Override
    public void setId(final String id) {
        idMixin.setId(id);
    }

    @Override
    public String getId() {
        return idMixin.getId();
    }
}
