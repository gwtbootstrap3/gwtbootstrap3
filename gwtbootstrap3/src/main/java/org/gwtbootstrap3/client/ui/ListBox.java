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

import com.google.gwt.dom.client.OptionElement;
import com.google.gwt.dom.client.SelectElement;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.HasValue;
import org.gwtbootstrap3.client.ui.base.HasId;
import org.gwtbootstrap3.client.ui.base.mixin.IdMixin;
import org.gwtbootstrap3.client.ui.constants.Styles;

/**
 * Convenience derivation from GWT's ListBox that can have an ID.
 *
 * @author Sven Jacobs
 * @see com.google.gwt.user.client.ui.ListBox
 */
public class ListBox extends com.google.gwt.user.client.ui.ListBox implements HasId, HasValue<String> {

    private final IdMixin<ListBox> idMixin = new IdMixin<ListBox>(this);
    private boolean valueChangeHandlerInitialized;

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

    @Override
    public String getValue() {
        return super.getSelectedValue();
    }

    @Override
    public void setValue(String value) {
        setValue(value, false);
    }

    @Override
    public void setValue(String value, boolean fireEvent) {
        SelectElement selectElement= getElement().cast();

        for (int i = 0; i < selectElement.getOptions().getLength(); i ++) {
            OptionElement option = selectElement.getOptions().getItem( i );

            if (option.getValue().equals(value)) {
                setSelectedIndex( i );
                if (fireEvent) {
                    ValueChangeEvent.fire(this, value);
                }
                return;
            }
        }
        setSelectedIndex(-1);
    }

    @Override
    public HandlerRegistration addValueChangeHandler(ValueChangeHandler<String> valueChangeHandler) {
        // Is this the first value change handler? If so, time to add handlers
        if (!valueChangeHandlerInitialized) {
            ensureDomEventHandlers();
            valueChangeHandlerInitialized = true;
        }
        return addHandler( valueChangeHandler, ValueChangeEvent.getType());
    }

    public void ensureDomEventHandlers() {
        addChangeHandler(new ChangeHandler() {
            @Override
            public void onChange(ChangeEvent event) {
                ValueChangeEvent.fire(ListBox.this, getSelectedValue());
            }
        });
    }
}
