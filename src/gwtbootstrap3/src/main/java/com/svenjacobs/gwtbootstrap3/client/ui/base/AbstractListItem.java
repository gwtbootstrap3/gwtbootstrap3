package com.svenjacobs.gwtbootstrap3.client.ui.base;

import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.ComplexPanel;
import com.google.gwt.user.client.ui.HasEnabled;
import com.svenjacobs.gwtbootstrap3.client.ui.HasActive;
import com.svenjacobs.gwtbootstrap3.client.ui.HasPull;
import com.svenjacobs.gwtbootstrap3.client.ui.base.helper.StyleHelper;
import com.svenjacobs.gwtbootstrap3.client.ui.base.mixin.ActiveMixin;
import com.svenjacobs.gwtbootstrap3.client.ui.base.mixin.PullMixin;
import com.svenjacobs.gwtbootstrap3.client.ui.constants.Pull;
import com.svenjacobs.gwtbootstrap3.client.ui.constants.Styles;

/**
 * Base class for list items.
 *
 * @author Sven Jacobs
 * @see com.svenjacobs.gwtbootstrap3.client.ui.ListItem
 * @see com.svenjacobs.gwtbootstrap3.client.ui.ListDropDown
 */
public abstract class AbstractListItem extends ComplexPanel implements HasEnabled, HasPull, HasActive {

    private final ActiveMixin activeMixin = new ActiveMixin(this);
    private final PullMixin pullMixin = new PullMixin(this);

    protected AbstractListItem() {
        setElement(DOM.createElement("li"));
    }

    @Override
    public void setEnabled(final boolean enabled) {
        if (enabled) {
            removeStyleName(Styles.DISABLED);
        } else {
            addStyleName(Styles.DISABLED);
        }
    }

    @Override
    public boolean isEnabled() {
        return !StyleHelper.containsStyle(getStyleName(), Styles.DISABLED);
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
    public void setActive(final boolean active) {
        activeMixin.setActive(active);
    }

    @Override
    public boolean isActive() {
        return activeMixin.isActive();
    }
}
