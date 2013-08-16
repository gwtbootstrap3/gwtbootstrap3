package com.svenjacobs.gwtbootstrap3.client.ui;

import com.google.gwt.user.client.DOM;
import com.svenjacobs.gwtbootstrap3.client.ui.base.ComplexWidget;
import com.svenjacobs.gwtbootstrap3.client.ui.base.mixin.PullMixin;
import com.svenjacobs.gwtbootstrap3.client.ui.constants.Attributes;
import com.svenjacobs.gwtbootstrap3.client.ui.constants.Pull;
import com.svenjacobs.gwtbootstrap3.client.ui.constants.Styles;

/**
 * Container for drop down menu items.
 * <p/>
 * <strong>Must</strong> be encapsulated in a {@link ButtonGroup} to build button dropdowns.
 *
 * @author Sven Jacobs
 * @see ButtonGroup
 */
public class DropDownMenu extends ComplexWidget implements HasPull {

    private final PullMixin pullMixin = new PullMixin(this);

    public DropDownMenu() {
        setElement(DOM.createElement("ul"));
        setStyleName(Styles.DROPDOWN_MENU);
        getElement().setAttribute(Attributes.ROLE, "menu");
    }

    @Override
    public void setPull(final Pull pull) {
        pullMixin.setPull(pull);
    }

    @Override
    public Pull getPull() {
        return pullMixin.getPull();
    }
}
