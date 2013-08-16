package com.svenjacobs.gwtbootstrap3.client.ui;

import com.google.gwt.user.client.DOM;
import com.svenjacobs.gwtbootstrap3.client.ui.base.ComplexWidget;
import com.svenjacobs.gwtbootstrap3.client.ui.constants.Styles;

/**
 * Div element that automatically centers contents.
 *
 * @author Sven Jacobs
 * @see Row
 * @see Column
 */
public class Container extends ComplexWidget {

    public Container() {
        setElement(DOM.createDiv());
        setStyleName(Styles.CONTAINER);
    }
}
