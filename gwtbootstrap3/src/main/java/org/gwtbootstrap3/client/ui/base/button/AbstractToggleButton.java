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

import org.gwtbootstrap3.client.ui.HasToggle;
import org.gwtbootstrap3.client.ui.Text;
import org.gwtbootstrap3.client.ui.base.mixin.ToggleMixin;
import org.gwtbootstrap3.client.ui.constants.ButtonType;
import org.gwtbootstrap3.client.ui.constants.Styles;
import org.gwtbootstrap3.client.ui.constants.Toggle;

/**
 * Base class for buttons that can be toggle buttons
 *
 * @author Sven Jacobs
 * @see AbstractButton
 * @see org.gwtbootstrap3.client.ui.constants.Toggle
 */
public abstract class AbstractToggleButton extends AbstractIconButton implements HasToggle {

    private final ToggleMixin<AbstractToggleButton> toggleMixin = new ToggleMixin<AbstractToggleButton>(this);
    private final Text separator = new Text(" ");
    private final Caret caret = new Caret();

    protected AbstractToggleButton() {
        this(ButtonType.DEFAULT);
    }

    protected AbstractToggleButton(final ButtonType type) {
        setType(type);
    }

    /**
     * Specifies that this button acts as a toggle, for instance for a parent {@link org.gwtbootstrap3.client.ui.DropDown}
     * or {@link org.gwtbootstrap3.client.ui.ButtonGroup}
     * <p/>
     * Adds a {@link Caret} as a child widget.
     *
     * @param toggle Kind of toggle
     */
    @Override
    public void setToggle(final Toggle toggle) {
        toggleMixin.setToggle(toggle);

        separator.removeFromParent();
        caret.removeFromParent();

        if (toggle == Toggle.DROPDOWN) {
            addStyleName(Styles.DROPDOWN_TOGGLE);

            add(separator, getElement());
            add(caret, getElement());
        }
    }

    @Override
    public Toggle getToggle() {
        return toggleMixin.getToggle();
    }
}
