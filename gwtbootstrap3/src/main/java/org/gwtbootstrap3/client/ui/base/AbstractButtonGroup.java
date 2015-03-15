package org.gwtbootstrap3.client.ui.base;

/*
 * #%L
 * GwtBootstrap3
 * %%
 * Copyright (C) 2013 - 2015 GwtBootstrap3
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

import org.gwtbootstrap3.client.ui.base.helper.StyleHelper;
import org.gwtbootstrap3.client.ui.base.mixin.DataToggleMixin;
import org.gwtbootstrap3.client.ui.base.mixin.PullMixin;
import org.gwtbootstrap3.client.ui.constants.ButtonGroupSize;
import org.gwtbootstrap3.client.ui.constants.DeviceSize;
import org.gwtbootstrap3.client.ui.constants.Pull;
import org.gwtbootstrap3.client.ui.constants.Styles;
import org.gwtbootstrap3.client.ui.constants.Toggle;
import org.gwtbootstrap3.client.ui.gwt.FlowPanel;

import com.google.gwt.user.client.ui.HasName;
import com.google.gwt.user.client.ui.Widget;

/**
 * Abstract base class for button groups.
 *
 * @author Sven Jacobs
 * @author Joshua Godi
 * @see org.gwtbootstrap3.client.ui.ButtonGroup
 * @see org.gwtbootstrap3.client.ui.VerticalButtonGroup
 */
public abstract class AbstractButtonGroup extends FlowPanel implements HasName, HasSize<ButtonGroupSize>,
        HasDataToggle, HasJustified, HasPull, HasResponsiveness {

    private final PullMixin<AbstractButtonGroup> pullMixin = new PullMixin<AbstractButtonGroup>(this);
    private final DataToggleMixin<AbstractButtonGroup> toggleMixin = new DataToggleMixin<AbstractButtonGroup>(this);
    private String name;

    protected AbstractButtonGroup(final String styleName) {
        setStyleName(styleName);
    }

    /**
     * Convenience method that will set the name of all child widgets that can have a name
     *
     * @param name Name of group
     * @see #add(com.google.gwt.user.client.ui.Widget)
     */
    @Override
    public void setName(final String name) {
        this.name = name;

        if (name == null) {
            return;
        }

        for (final Widget w : getChildren()) {
            if (w instanceof HasName) {
                ((HasName) w).setName(name);
            }
        }
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setSize(ButtonGroupSize size) {
        StyleHelper.addUniqueEnumStyleName(this, ButtonGroupSize.class, size);
    }

    @Override
    public ButtonGroupSize getSize() {
        return ButtonGroupSize.fromStyleName(getStyleName());
    }

    @Override
    public void setDataToggle(final Toggle toggle) {
        toggleMixin.setDataToggle(toggle);
    }

    @Override
    public Toggle getDataToggle() {
        return toggleMixin.getDataToggle();
    }

    /**
     * Make a group of buttons stretch at the same size to span the entire width of its parent.
     * <p/>
     * <strong>Note:</strong> Justified button groups only work with {@link org.gwtbootstrap3.client.ui.AnchorButton} child elements!
     *
     * @param justified Stretch button group
     */
    @Override
    public void setJustified(final boolean justified) {
        if (justified) {
            addStyleName(Styles.BTN_GROUP_JUSTIFIED);
        } else {
            removeStyleName(Styles.BTN_GROUP_JUSTIFIED);
        }
    }

    @Override
    public boolean isJustified() {
        return StyleHelper.containsStyle(getStyleName(), Styles.BTN_GROUP_JUSTIFIED);
    }

    @Override
    public void setPull(final Pull pull) {
        pullMixin.setPull(pull);
    }

    @Override
    public Pull getPull() {
        return pullMixin.getPull();
    }

    @Override
    public void setVisibleOn(final DeviceSize deviceSize) {
        StyleHelper.setVisibleOn(this, deviceSize);
    }

    @Override
    public void setHiddenOn(final DeviceSize deviceSize) {
        StyleHelper.setHiddenOn(this, deviceSize);
    }

    /**
     * Makes this a "drop up" container for dropdown menus where the menu opens upwards.
     *
     * @param dropUp display up or not
     */
    public void setDropUp(final boolean dropUp) {
        if (dropUp) {
            addStyleName(Styles.DROP_UP);
        } else {
            removeStyleName(Styles.DROP_UP);
        }
    }

    @Override
    public void add(final Widget w) {
        super.add(w);

        if (name == null) {
            return;
        }

        // Add group's name to child widgets that can have a name
        if (w instanceof HasName) {
            ((HasName) w).setName(name);
        }
    }
}
