package com.svenjacobs.gwtbootstrap3.client.ui;

import com.google.gwt.user.client.DOM;
import com.svenjacobs.gwtbootstrap3.client.ui.base.ComplexWidget;
import com.svenjacobs.gwtbootstrap3.client.ui.constants.Styles;

/**
 * Container for {@link ListItem} or {@link ListDropDown} within {@link Navbar}.
 *
 * @author Sven Jacobs
 * @see Navbar
 * @see ListItem
 * @see ListDropDown
 */
public class NavbarNav extends ComplexWidget {

    public NavbarNav() {
        setElement(DOM.createElement("ul"));
        setStyleName(Styles.NAV);
        addStyleName(Styles.NAVBAR_NAV);
    }
}
