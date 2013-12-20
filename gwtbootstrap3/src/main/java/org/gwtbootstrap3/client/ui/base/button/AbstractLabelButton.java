package org.gwtbootstrap3.client.ui.base.button;

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

import com.google.gwt.dom.client.Element;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.HasName;
import com.google.gwt.user.client.ui.HasValue;
import org.gwtbootstrap3.client.ui.CheckableInputButton;
import org.gwtbootstrap3.client.ui.HasActive;
import org.gwtbootstrap3.client.ui.HasFormValue;
import org.gwtbootstrap3.client.ui.base.mixin.ActiveMixin;
import org.gwtbootstrap3.client.ui.constants.ButtonType;
import org.gwtbootstrap3.client.ui.constants.Styles;
import org.gwtbootstrap3.client.ui.constants.TypeAttrType;

/**
 * Base class for {@link org.gwtbootstrap3.client.ui.CheckBoxButton}
 * and {@link org.gwtbootstrap3.client.ui.RadioButton} which are
 * encapsulated {@code <input>} elements within {@code <label>}.
 *
 * @author Sven Jacobs
 */
public abstract class AbstractLabelButton extends AbstractIconButton implements HasActive, HasName, HasFormValue, HasValue<Boolean> {

    private final ActiveMixin<AbstractLabelButton> activeMixin = new ActiveMixin<AbstractLabelButton>(this);
    protected final CheckableInputButton input;

    protected AbstractLabelButton(final TypeAttrType typeAttr) {
        super(ButtonType.DEFAULT);

        input = new CheckableInputButton(typeAttr);
        input.setStyleName("");

        add(input, getElement());
        iconTextMixin.addTextWidgetToParent();
    }

    protected AbstractLabelButton(final TypeAttrType typeAttr,
                                  final String label) {

        this(typeAttr);
        setText(label);
    }

    @Override
    public void setEnabled(final boolean enabled) {
        if (enabled) {
            removeStyleName(Styles.DISABLED);
        } else {
            addStyleName(Styles.DISABLED);
        }

        input.setEnabled(enabled);
    }

    @Override
    public boolean isEnabled() {
        return input.isEnabled();
    }

    @Override
    public void setActive(final boolean active) {
        setValue(active);
    }

    @Override
    public boolean isActive() {
        return activeMixin.isActive();
    }

    @Override
    public void setName(final String name) {
        input.setName(name);
    }

    @Override
    public String getName() {
        return input.getName();
    }

    @Override
    public String getFormValue() {
        return input.getFormValue();
    }

    @Override
    public void setFormValue(final String value) {
        input.setFormValue(value);
    }

    @Override
    public void setValue(final Boolean value) {
        setValue(value, false);
    }

    @Override
    public void setValue(final Boolean value, final boolean fireEvents) {
        activeMixin.setActive(value);
        input.setValue(value, fireEvents);
    }

    @Override
    public Boolean getValue() {
        return input.getValue();
    }

    @Override
    public HandlerRegistration addValueChangeHandler(final ValueChangeHandler<Boolean> handler) {
        return input.addValueChangeHandler(handler);
    }

    @Override
    protected Element createElement() {
        return DOM.createLabel();
    }
}
