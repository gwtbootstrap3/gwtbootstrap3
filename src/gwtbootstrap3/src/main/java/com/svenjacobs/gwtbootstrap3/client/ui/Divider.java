package com.svenjacobs.gwtbootstrap3.client.ui;

import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.Widget;
import com.svenjacobs.gwtbootstrap3.client.ui.constants.Styles;

/**
 * Divider used within {@link DropDownMenu} between {@link ListItem} elements.
 *
 * @author Sven Jacobs
 */
public class Divider extends Widget {

    public Divider() {
        setElement(DOM.createElement("li"));
        setStyleName(Styles.DIVIDER);
    }
}
