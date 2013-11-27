package com.svenjacobs.gwtbootstrap3.client.ui.base;

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

import com.google.gwt.user.client.ui.ComplexPanel;
import com.google.gwt.user.client.ui.Widget;
import com.svenjacobs.gwtbootstrap3.client.ui.HasId;
import com.svenjacobs.gwtbootstrap3.client.ui.base.mixin.IdMixin;

/**
 * Base class for widgets that contain further widgets.
 *
 * @author Sven Jacobs
 */
public class ComplexWidget extends ComplexPanel implements HasId {
    private final IdMixin<ComplexWidget> idMixin = new IdMixin<ComplexWidget>(this);

    @Override
    public void add(final Widget child) {
        add(child, getElement());
    }

    /**
     * Inserts a widget at a specific index
     *
     * @param child       - widget to be inserted
     * @param beforeIndex - index for the widget
     */
    public void insert(Widget child, int beforeIndex) {
        insert(child, getElement(), beforeIndex, true);
    }

    @Override
    public void setId(String id) {
        idMixin.setId(id);
    }

    @Override
    public String getId() {
        return idMixin.getId();
    }
}
