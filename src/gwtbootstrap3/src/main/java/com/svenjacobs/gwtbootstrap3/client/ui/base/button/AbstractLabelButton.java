package com.svenjacobs.gwtbootstrap3.client.ui.base.button;

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
import com.google.gwt.user.client.Element;
import com.svenjacobs.gwtbootstrap3.client.ui.HasActive;
import com.svenjacobs.gwtbootstrap3.client.ui.InputButton;
import com.svenjacobs.gwtbootstrap3.client.ui.base.mixin.ActiveMixin;
import com.svenjacobs.gwtbootstrap3.client.ui.constants.ButtonType;
import com.svenjacobs.gwtbootstrap3.client.ui.constants.Styles;
import com.svenjacobs.gwtbootstrap3.client.ui.constants.TypeAttrType;

/**
 * Base class for {@link com.svenjacobs.gwtbootstrap3.client.ui.CheckBoxButton} and
 * {@link com.svenjacobs.gwtbootstrap3.client.ui.RadioButton} which are encapsulated {@code <input>} elements within
 * {@code <label>}.
 *
 * @author Sven Jacobs
 */
public abstract class AbstractLabelButton extends AbstractIconButton implements HasActive {

    private final ActiveMixin activeMixin = new ActiveMixin(this);
    private final InputButton input;

    protected AbstractLabelButton(final TypeAttrType typeAttr) {
        super(ButtonType.DEFAULT);

        input = new InputButton(typeAttr);
        input.setStyleName("");

        add(input, getElement());
        add(text, getElement());
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
        activeMixin.setActive(active);
    }

    @Override
    public boolean isActive() {
        return activeMixin.isActive();
    }

    @Override
    protected Element createElement() {
        return DOM.createLabel();
    }
}
