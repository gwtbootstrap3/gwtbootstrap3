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

import com.google.gwt.user.client.DOM;
import com.svenjacobs.gwtbootstrap3.client.ui.base.ComplexWidget;
import com.svenjacobs.gwtbootstrap3.client.ui.constants.Styles;

/**
 * @author Joshua Godi
 */
public class UnorderedList extends ComplexWidget {

    /**
     * Creates an empty list.
     */
    public UnorderedList() {
        setElement(DOM.createElement("ul"));
    }

    /**
     * Creates a list and adds the given widgets.
     *
     * @param widgets widgets to be added
     */
    public UnorderedList(ListItem... widgets) {
        this();
        for (ListItem li : widgets) {
            add(li);
        }
    }

    public void setUnstyled(boolean unstyled) {
        setStyleName(Styles.UNSTYLED, unstyled);
    }

    public void setInline(boolean inline) {
        if (inline) {
            addStyleName(Styles.LIST_INLINE);
        }
    }
}