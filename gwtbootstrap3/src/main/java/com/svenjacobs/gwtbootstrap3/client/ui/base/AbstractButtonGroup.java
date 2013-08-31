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

import com.svenjacobs.gwtbootstrap3.client.ui.FlowPanel;
import com.svenjacobs.gwtbootstrap3.client.ui.HasJustified;
import com.svenjacobs.gwtbootstrap3.client.ui.HasPull;
import com.svenjacobs.gwtbootstrap3.client.ui.HasToggle;
import com.svenjacobs.gwtbootstrap3.client.ui.base.helper.StyleHelper;
import com.svenjacobs.gwtbootstrap3.client.ui.base.mixin.PullMixin;
import com.svenjacobs.gwtbootstrap3.client.ui.base.mixin.ToggleMixin;
import com.svenjacobs.gwtbootstrap3.client.ui.constants.Pull;
import com.svenjacobs.gwtbootstrap3.client.ui.constants.Styles;
import com.svenjacobs.gwtbootstrap3.client.ui.constants.Toggle;

/**
 * Abstract base class for button groups.
 *
 * @author Sven Jacobs
 * @see com.svenjacobs.gwtbootstrap3.client.ui.ButtonGroup
 * @see com.svenjacobs.gwtbootstrap3.client.ui.VerticalButtonGroup
 */
public abstract class AbstractButtonGroup extends FlowPanel implements HasToggle, HasJustified, HasPull {

    private final PullMixin<AbstractButtonGroup> pullMixin = new PullMixin<AbstractButtonGroup>(this);
    private final ToggleMixin<AbstractButtonGroup> toggleMixin = new ToggleMixin<AbstractButtonGroup>(this);

    protected AbstractButtonGroup(final String styleName) {
        setStyleName(styleName);
    }

    @Override
    public void setToggle(final Toggle toggle) {
        toggleMixin.setToggle(toggle);
    }

    @Override
    public Toggle getToggle() {
        return toggleMixin.getToggle();
    }

    /**
     * Make a group of buttons stretch at the same size to span the entire width of its parent.
     * <p/>
     * <strong>Note:</strong> Justified button groups only work with {@link com.svenjacobs.gwtbootstrap3.client.ui.AnchorButton} child elements!
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

    /**
     * Makes this a "drop up" container for dropdown menus where the menu opens upwards.
     *
     * @param dropUp
     */
    public void setDropUp(final boolean dropUp) {
        if (dropUp) {
            addStyleName(Styles.DROP_UP);
        } else {
            removeStyleName(Styles.DROP_UP);
        }
    }
}
