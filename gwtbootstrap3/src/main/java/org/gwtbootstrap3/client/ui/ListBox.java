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

import org.gwtbootstrap3.client.ui.base.HasId;
import org.gwtbootstrap3.client.ui.base.mixin.IdMixin;
import org.gwtbootstrap3.client.ui.constants.Styles;

/**
 * Convenience derivation from GWT's ListBox that can have an ID.
 *
 * @author Sven Jacobs
 * @see com.google.gwt.user.client.ui.ListBox
 */
public class ListBox extends com.google.gwt.user.client.ui.ListBox implements HasId {

    private final IdMixin<ListBox> idMixin = new IdMixin<ListBox>(this);

    /**
     * Creates an empty list box in single selection mode.
     */
    public ListBox() {
        super();
        setStyleName(Styles.FORM_CONTROL);
    }

    /**
     * Creates an empty list box.
     *
     * @param isMultipleSelect
     *            specifies if multiple selection is enabled
     * @deprecated use {@link #setMultipleSelect(boolean)} instead.
     */
    @Deprecated
    public ListBox(final boolean isMultipleSelect) {
        this();
        setMultipleSelect(isMultipleSelect);
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
