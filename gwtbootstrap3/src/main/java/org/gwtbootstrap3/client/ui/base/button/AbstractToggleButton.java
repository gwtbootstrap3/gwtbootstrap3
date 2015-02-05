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

import org.gwtbootstrap3.client.ui.base.HasDataToggle;
import org.gwtbootstrap3.client.ui.base.mixin.DataToggleMixin;
import org.gwtbootstrap3.client.ui.constants.ButtonType;
import org.gwtbootstrap3.client.ui.constants.Styles;
import org.gwtbootstrap3.client.ui.constants.Toggle;
import org.gwtbootstrap3.client.ui.html.Text;

import com.google.gwt.core.client.Scheduler;
import com.google.gwt.dom.client.Element;

/**
 * Base class for buttons that can be toggle buttons
 *
 * @author Sven Jacobs
 * @see AbstractButton
 * @see org.gwtbootstrap3.client.ui.constants.Toggle
 */
public abstract class AbstractToggleButton extends AbstractIconButton implements HasDataToggle {

    private final DataToggleMixin<AbstractToggleButton> toggleMixin = new DataToggleMixin<AbstractToggleButton>(this);
    private final Text separator = new Text(" ");
    private final Caret caret = new Caret();

    protected AbstractToggleButton() {
        this(ButtonType.DEFAULT);
    }

    protected AbstractToggleButton(final ButtonType type) {
        setType(type);
        iconTextMixin.addTextWidgetToParent();
    }

    /**
     * Toggles the display of the caret for the button
     * @param toggleCaret show/hide the caret for the button
     */
    public void setToggleCaret(final boolean toggleCaret) {
        caret.setVisible(toggleCaret);
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
    public void setDataToggle(final Toggle toggle) {
        toggleMixin.setDataToggle(toggle);

        // We defer to make sure the elements are available to manipulate their position
        Scheduler.get().scheduleDeferred(new Scheduler.ScheduledCommand() {
            @Override
            public void execute() {
                separator.removeFromParent();
                caret.removeFromParent();

                if (toggle == Toggle.DROPDOWN) {
                    addStyleName(Styles.DROPDOWN_TOGGLE);

                    add(separator, (Element) getElement());
                    add(caret, (Element) getElement());
                }
            }
        });
    }

    @Override
    public Toggle getDataToggle() {
        return toggleMixin.getDataToggle();
    }
}
